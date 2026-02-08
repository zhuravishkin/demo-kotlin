package com.zhuravishkin.demo_kotlin.demo

import java.math.BigDecimal
import java.time.Instant

class PrePersistDemo {
}

class BusinessAccountOperationEntity(
    val businessAccountId: Long,
    val amount: BigDecimal
) {
    var parentId: Long? = null
    var description: String? = null
    var metadata: String? = null
    lateinit var operationDateTime: Instant
    lateinit var createdAt: Instant

    //    @PrePersist
    fun onPersist() {
        createdAt = Instant.now()
        if (!::operationDateTime.isInitialized) {
            operationDateTime = createdAt
        }
    }
}
