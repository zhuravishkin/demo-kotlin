package com.zhuravishkin.demo_kotlin.udemy.g_inheritance

/*
Для созданных в предыдущих задачах классов Rectangle и Round (нужно сюда скопировать ваш код этих классов)
пропишите суперкласс Figure, в котором будет поле цвет типа String, которое должно инициализироваться через конструктор
и два поля x и y типа Int, которые будут задавать положение фигуры в пространстве относитльено начала координат
и инициализироваться в теле класса начальными значениями ноль.

Пропишите в этом классе функции moveLeft(step: Int), moveRight(step: Int), moveDown(step: Int), moveUp(step: Int),
которые будут сдвигать фигуру, то есть менять ее координаты x и y

Сделайте Rectangle и Round наследниками класса Figure

Для этой задачи есть видео с разбором.
*/

fun main() {
    val rectangle: Rectangle = Rectangle("Red", 4.5, 4.5)
    rectangle.moveRight(5)
    println(rectangle)
}

open class Figure(private val color: String) {
    private var x: Int = 0
    private var y: Int = 0

    fun moveLeft(step: Int) {
        x -= step
    }

    fun moveRight(step: Int) {
        x += step
    }

    fun moveDown(step: Int) {
        y -= step
    }

    fun moveUp(step: Int) {
        y += step
    }

    override fun toString(): String {
        return "Figure(color='$color', x=$x, y=$y)"
    }
}

class Rectangle(color: String, val width: Double, val height: Double) : Figure(color) {
    fun getArea(): Double {
        return width * height
    }

    fun getLength(): Double {
        return 2 * (width + height)
    }

    fun isSquare(): Boolean {
        return width == height
    }

    override fun toString(): String {
        return "Rectangle(${super.toString()}, width=$width, height=$height)"
    }
}

class Round(color: String, val radius: Double) : Figure(color) {
    fun getArea(): Double {
        return Math.PI * radius * radius
    }

    fun getLength(): Double {
        return 2 * Math.PI * radius
    }
}
