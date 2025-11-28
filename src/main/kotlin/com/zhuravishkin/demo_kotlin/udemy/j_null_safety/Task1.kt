package com.zhuravishkin.demo_kotlin.udemy.j_null_safety

/*
1.	Есть класс:
    class SomeEmployee(
            val name: String,
            val salary: Int
    ) {
        fun callToClient(clientName: String) {
            println("Сотрудник ${name}: звоню клиенту $clientName")
        }
    }

Написать функцию
fun findEmployeeBySalary(employees: List<SomeEmployee>, age: Int): SomeEmployee?
которая ищет в списке сотрудников сотрудника с заданной зарплатой.
Сделайте так, чтобы функция возвращала null в случае если такого сотрудника в списке нет
Создать произвольный список сотрудников. Используя эту функцию найти в списке сотрудника с определенной зарплатой.
Вызвать у него функцию callToClient, используя безопасный вызов (?)
*/

fun main() {
    val employees = listOf(
        SomeEmployee("Sam", 5000),
        SomeEmployee("Dean", 7000),
        SomeEmployee("John", 6000)
    )

    println(findEmployeeBySalary(employees, 5000))
}

fun findEmployeeBySalary(employees: List<SomeEmployee>, salary: Int): SomeEmployee? {
    for (employee in employees)
        if (salary == employee.salary)
            return employee
    return null
}

class SomeEmployee(val name: String, val salary: Int) {
    fun callToClient(clientName: String) {
        println("Сотрудник ${name}: звоню клиенту $clientName")
    }

    override fun toString(): String {
        return "SomeEmployee(name='$name', salary=$salary)"
    }
}