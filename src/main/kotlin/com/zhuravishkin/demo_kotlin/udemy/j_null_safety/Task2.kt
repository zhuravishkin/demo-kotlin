package com.zhuravishkin.demo_kotlin.udemy.j_null_safety

/*
Есть классы:
class Address(val address: String, val city: String)
class Company(val name: String, val address: Address?)
class Employee(val name: String, val company: Company?)

Напишите функцию fun employeeCity(employee: Employee): String, которая возвращает название города,
в которой располагается организация, в которой работает данный человек.
В случае если он нигде не работает (в company лежит null), функция должна выводить: «Неизвестен»
Используйте функции безопасного вызова и оператор элвис

Для этой задачи есть видео с разбором.
*/

fun main() {
    val address = Address("ul. Gorkogo, 16", "Moscow")
    val company = Company("X5Tech", address)
    val employee = Employee("Kirill", company)

    println(employeeCity(employee))
}

fun employeeCity(employee: Employee): String {
    return employee.company?.address?.address ?: "Неизвестен"
}

class Address(val address: String, val city: String)
class Company(val name: String, val address: Address?)
class Employee(val name: String, val company: Company?)