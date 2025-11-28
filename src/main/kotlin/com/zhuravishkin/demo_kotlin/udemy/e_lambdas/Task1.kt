package com.zhuravishkin.demo_kotlin.udemy.e_lambdas

/*
Написать функцию преобразования каждого элемента коллекции пользователей в String в соответствии с заданным лямбда-выражением
fun convertToStrings(users: List<User>, conversion: (User) -> String): List<String>

Дата класс User уже описан в отдельном файле в этом разделе и доступен здесь.

Проверить работу написанной функции на примере каких-нибудь входных данных.

Для этой задачи есть видео с разбором.
*/

fun main() {
    val users = arrayListOf<User>()
    users.add(User("John", 40))
    users.add(User("Sam", 29))
    users.add(User("Dean", 35))

    println(convertToStrings(users) { it.toString() })
    println(convertToStrings(users) { "name: ${it.name} : age: ${it.age}" })
}

fun convertToStrings(users: List<User>, conversion: (User) -> String): List<String> {
    val list = mutableListOf<String>()
    for (user in users) {
        list.add(conversion(user))
    }
    return list
}
