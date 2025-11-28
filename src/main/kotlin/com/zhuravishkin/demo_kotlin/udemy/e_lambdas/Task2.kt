package com.zhuravishkin.demo_kotlin.udemy.e_lambdas

/*
Написать функцию, которая отвечает на вопрос, присутствует ли в коллекции элемент, который удовлетворяет условиям
fun containsElement(users: List<User>, condition: (User) -> Boolean): Boolean


Дата класс User уже описан в отдельном файле в этом разделе и доступен здесь.

Проверить работу написанной функции на примере каких-нибудь входных данных.

Для этой задачи есть видео с разбором.
*/

fun main() {
    val users = arrayListOf<User>(
        User("John", 40),
        User("Sam", 29),
        User("Dean", 35)
    )

    println(containsElement(users) { it.age > 30 })
}

fun containsElement(users: List<User>, condition: (User) -> Boolean): Boolean {
    for (user in users)
        if (condition(user)) return true
    return false
}