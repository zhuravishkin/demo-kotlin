package com.zhuravishkin.demo_kotlin.demo

fun main() {
    val users = listOf(
        User("Sam", 17),
        User("Dean", 23),
        User("John", 30)
    )

    filterUsers(users, ::lambda)

    val lambda = { user: User -> user.age > 25 }
    filterUsers(users, lambda)

    filterUsers(users) { lambda(it) }

    filterUsers(users) { user -> user.age > 25 }

    filterUsers(users) { it.age > 25 }

    filter() { true }
    filter { true }

    println(users)
    println(users.sortedBy { it.name })
    println(users.sortedByDescending { it.name })
}

data class User(val name: String, val age: Int)

fun filterUsers(users: List<User>, condition: (User) -> Boolean) {
    return users.forEach { if (condition(it)) println(it) }
}

fun filter(condition: () -> Boolean): Boolean {
    return condition()
}

fun lambda(user: User): Boolean {
    return user.age > 25
}
