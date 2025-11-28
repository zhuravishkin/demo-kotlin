package com.zhuravishkin.demo_kotlin.sergey_arkhipov

fun main() {
    10 apply { it * 2 } apply { "String value: $it" } apply { it.lowercase() }

    val person = Person(name = "Vasya", age = 25)

    person apply2 { name = "Petya"; age = 30 }

    person apply2 { name } apply { println(it) }
}

inline infix fun <T, R> T.apply(func: (x: T) -> R): R {
    return func(this)
}

inline infix fun <T, R> T.apply2(func: T.() -> R): R {
    return this.func()
}

//class Person(var name: String = "", var age: Int)

class Person() {
    var name: String = ""
        get() = "Mr. $field"
    var age: Int = 0
        set(value) {
            field = value
        }

    constructor(name: String, age: Int) : this() {
        this.name = name
        this.age = age
    }
}
