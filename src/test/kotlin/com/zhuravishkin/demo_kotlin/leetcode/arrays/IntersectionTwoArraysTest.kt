package com.zhuravishkin.demo_kotlin.leetcode.arrays

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class IntersectionTwoArraysTest {
    private val sut = IntersectionTwoArrays()

    @Test
    fun intersection() {
        val nums1 = intArrayOf(1, 2, 2, 1)
        val nums2 = intArrayOf(2, 2)

        val result = sut.intersection(nums1, nums2)
        assertEquals(result, intArrayOf(2))
    }
}
