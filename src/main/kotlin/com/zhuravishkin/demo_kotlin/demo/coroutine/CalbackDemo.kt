package com.zhuravishkin.demo_kotlin.demo.coroutine

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import java.util.*
import java.util.concurrent.CompletableFuture
import kotlin.system.measureTimeMillis

// ------------------ Модели ------------------

data class Token(val value: String)
data class Item(val name: String)
data class Post(val text: String)

// ------------------ CALLBACK VERSION ------------------

fun requestTokenAsync(cb: (Token) -> Unit) {
    Thread {
        Thread.sleep(500)
        cb(Token("abc123"))
    }.start()
}

fun createPostAsync(token: Token, item: Item, cb: (Post) -> Unit) {
    Thread {
        Thread.sleep(500)
        cb(Post("Created post with ${item.name} using token ${token.value}"))
    }.start()
}

fun processPost(post: Post) {
    println("Processing post: ${post.text}")
}

fun postItemWithCallbacks(item: Item) {
    requestTokenAsync { token ->
        createPostAsync(token, item) { post ->
            processPost(post)
        }
    }
}

// ------------------ FUTURE VERSION ------------------

fun requestTokenFuture(): CompletableFuture<Token> =
    CompletableFuture.supplyAsync {
        Thread.sleep(500)
        Token("future-123")
    }

fun createPostFuture(token: Token, item: Item): CompletableFuture<Post> =
    CompletableFuture.supplyAsync {
        Thread.sleep(500)
        Post("Created post with ${item.name} using token ${token.value}")
    }

fun postItemWithFuture(item: Item) {
    requestTokenFuture()
        .thenCompose { token -> createPostFuture(token, item) }
        .thenAccept { post -> processPost(post) }
        .join() // чтобы дождаться завершения
}

// ------------------ COROUTINE VERSION ------------------

suspend fun requestTokenCoroutine(): Token {
    delay(500)
    return Token("coroutine-123")
}

suspend fun createPostCoroutine(token: Token, item: Item): Post {
    delay(500)
    return Post("Created post with ${item.name} using token ${token.value}")
}

suspend fun postItemWithCoroutine(item: Item) {
    val token = requestTokenCoroutine()
    val post = createPostCoroutine(token, item)
    processPost(post)
}

// ------------------ MAIN ------------------

fun main() = runBlocking {
    val item = Item("Test Item")

    println("=== CALLBACKS ===")
    postItemWithCallbacks(item)
    delay(Random().nextInt(5000).toLong())  // подождём завершения потоков

    println("\n=== FUTURES ===")
    postItemWithFuture(item)

    println("\n=== COROUTINES ===")
    val time = measureTimeMillis {
        postItemWithCoroutine(item)
    }
    println("Coroutine flow completed in $time ms")
}
