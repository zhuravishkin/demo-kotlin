package com.zhuravishkin.demo_kotlin.leetcode.arrays

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class IntersectionTwoArraysIITest {
    private val sut = IntersectionTwoArraysII()

    @Test
    fun `intersection 1`() {
        // given
        val nums1 = intArrayOf(1, 2, 2, 1)
        val nums2 = intArrayOf(2, 2)

        // when
        val result = sut.intersection(nums1, nums2)

        // then
        assertArrayEquals(result, intArrayOf(2, 2))
    }

    @Test
    fun `intersection 2`() {
        // given
        val nums1 = intArrayOf(4, 9, 5)
        val nums2 = intArrayOf(9, 4, 9, 8, 4)

        // when
        val result = sut.intersection(nums1, nums2)

        // then
        assertArrayEquals(result, intArrayOf(4, 9))
    }
}
