package com.zhuravishkin.demo_kotlin.demo.coroutine

import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import java.util.*

//fun main(): Unit = runBlocking {
////    GlobalScope.launch {  }
//    repeat(100) {
////        val result = test(it.toString())
////        println(result)
//        launch {
//            val result = test(it.toString())
//            println(result)
//        }
//    }
//}

fun main(): Unit = runBlocking {
    val coroutines: List<Deferred<String>> = List(100) {
        async {
            test(it.toString())
        }
    }
    coroutines.forEach { println(it.await()) }
}

suspend fun test(name: String): String {
    delay(Random().nextInt(5000).toLong())
    return "done: $name"
}
