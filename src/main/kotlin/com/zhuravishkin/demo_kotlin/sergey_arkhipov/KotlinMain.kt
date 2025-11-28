package com.zhuravishkin.demo_kotlin.sergey_arkhipov

class Main {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println("Hello World")
        }
    }
}

fun main() {
    getParam(1, "test")
    getParam(param2 = "test2", param1 = 2)
    getNull()
    getArr()
}

fun getParam(param1: Int, param2: String) {
    println("param1: $param1, param2: $param2")
}

fun getNull(): Unit {
    var strNotNullable: String = "hello"
    val strNullable: String? = null
    strNotNullable = strNullable ?: "default"
    println(strNotNullable)

    val length = strNullable?.length
    println(length)

    strNotNullable?.let { println() }
}

fun getArr() {
    val arr = arrayOf(1, 2, 3)
    for ((i, j) in arr.withIndex()) {
        println(i to j)
    }
}
