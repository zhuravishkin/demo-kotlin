package com.zhuravishkin.demo_kotlin.udemy.i_interfaces

/*
Создайте интерфейс Movable (перемещаемый), в котором будут описаны функции moveLeft(step: Int), moveRight(step: Int),
moveDown(step: Int), moveUp(step: Int).

Сделайте так, чтобы класс Figure из предыдущего задания реализовывал интерфейс Movable (скопируйте сюда код написанного
вами класса Figure)

Для этой задачи есть видео с разбором.
*/

interface Movable {
    fun moveLeft(step: Int)

    fun moveRight(step: Int)

    fun moveDown(step: Int)

    fun moveUp(step: Int)
}

abstract class Figure(private val color: String) : Movable {
    private var x: Int = 0
    private var y: Int = 0

    override fun moveLeft(step: Int) {
        x -= step
    }

    override fun moveRight(step: Int) {
        x += step
    }

    override fun moveDown(step: Int) {
        y -= step
    }

    override fun moveUp(step: Int) {
        y += step
    }

    abstract fun getArea(): Double

    abstract fun getLength(): Double

    override fun toString(): String {
        return "Figure(color='$color', x=$x, y=$y)"
    }
}