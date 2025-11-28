package com.zhuravishkin.demo_kotlin.udemy.h_abstract_classes

/*
Сделать класс Figure, из предыдущего урока абстрактным, перенести объявление функции area и length в него,
оставив реализацию полиморфной для классов Rectangle и Round
Для этого предварительно скопируйте сюда код классов, который вы написали в предыдущей задаче

Для этой задачи есть видео с разбором.
*/

fun main() {
    val rectangle: Rectangle = Rectangle("Red", 4.5, 4.5)
    rectangle.moveRight(5)
    println(rectangle)
}

abstract class Figure(private val color: String) {
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

    abstract fun getArea(): Double

    abstract fun getLength(): Double

    override fun toString(): String {
        return "Figure(color='$color', x=$x, y=$y)"
    }
}

class Rectangle(color: String, val width: Double, val height: Double) : Figure(color) {
    override fun getArea(): Double {
        return width * height
    }

    override fun getLength(): Double {
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
    override fun getArea(): Double {
        return Math.PI * radius * radius
    }

    override fun getLength(): Double {
        return 2 * Math.PI * radius
    }
}