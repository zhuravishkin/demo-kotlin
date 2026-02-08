package com.zhuravishkin.demo_kotlin.leetcode.arrays

/*
* 350. Intersection of Two Arrays II
*/
class IntersectionTwoArraysII {
    fun intersection(nums1: IntArray, nums2: IntArray): IntArray {
        nums1.sort()
        nums2.sort()

        val result = mutableListOf<Int>()
        var i = 0
        var j = 0

        while (i < nums1.size && j < nums2.size) {
            val p1 = nums1[i]
            val p2 = nums2[j]
            if (p1 == p2) {
                result.add(p1)
                i++
                j++
            } else if (p1 < p2)
                i++
            else
                j++
        }

        return result.toIntArray()
    }
}
