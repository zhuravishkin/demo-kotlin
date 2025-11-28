package com.zhuravishkin.demo_kotlin.udemy.k_exceptions

/*
Переделайте функцию findEmployeeBySalary из задачи по null safety таким образом, чтобы ее возвращаемый тип
был SomeEmployee-а не SomeEmployee? .
А в случае если подходящий сотрудник не найден, выбрасывайте исключительную ситуацию.
Вызовите эту функцию из main, обернув ее в try catch, обработав эту исключительную ситуацию в функции main.

p.s. здесь речь не идет о том, что такой вариант в данном случае предпочтительнее, чем использование null.
Рассматривайте это просто как практику работы с Exceptions

Для этой задачи есть видео с разбором.
*/

fun main() {
    val employees = listOf(
        SomeEmployee("Sam", 5000),
        SomeEmployee("Dean", 7000),
        SomeEmployee("John", 6000)
    )

    try {
        println(findEmployeeBySalary(employees, 8000))
    } catch (e: Exception) {
        println("Перехвачено исключение: ${e.message}")
    }
}

fun findEmployeeBySalary(employees: List<SomeEmployee>, salary: Int): SomeEmployee {
    for (employee in employees)
        if (salary == employee.salary)
            return employee
    throw Exception("Сотрудник с зарплатой $salary не найден")
}

class SomeEmployee(val name: String, val salary: Int) {
    fun callToClient(clientName: String) {
        println("Сотрудник ${name}: звоню клиенту $clientName")
    }

    override fun toString(): String {
        return "SomeEmployee(name='$name', salary=$salary)"
    }
}
