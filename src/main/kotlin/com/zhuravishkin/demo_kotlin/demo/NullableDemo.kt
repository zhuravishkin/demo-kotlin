package com.zhuravishkin.demo_kotlin.demo

class NullableDemo {
}

fun main() {
    val s: String? = null
    val i = s?.length
//    val j = 5 + i
    println("hi, $i")
}
