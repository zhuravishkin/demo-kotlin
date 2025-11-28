package com.zhuravishkin.demo_kotlin.udemy.f_classes_and_objects

/*
Напишите класс прямоугольника (Rectangle) с полями width и height (ширина и высота), инициализирующимися через конструктор.
Добавьте в него функции, которые будут считать площадь (width*height) и периметр прямоугольника (2*(width+height))
Добавьте функцию, которая будет отвечать на вопрос является ли этот прямоугольник квадратом (равны ли его стороны)
Создайте объект класса Rectangle и проверьте работоспособность написанных функций

Для этой задачи есть видео с разбором.
*/

fun main() {
    val rectangle: Rectangle = Rectangle(4.5, 4.5)
    println(rectangle.getArea())
    println(rectangle.getLength())
    println(rectangle.isSquare())
}

class Rectangle(val width: Double, val height: Double) {
    fun getArea(): Double {
        return width * height
    }

    fun getLength(): Double {
        return 2 * (width + height)
    }

    fun isSquare(): Boolean {
        return width == height
    }
}
