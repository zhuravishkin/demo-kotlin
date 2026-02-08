package com.zhuravishkin.demo_kotlin.demo.collection

import com.zhuravishkin.demo_kotlin.demo.collection.MapDemo.*
import java.math.BigDecimal
import java.time.Instant
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter

class MapDemo {
    data class Operation(
        val id: Int,
        val parentId: Int?,
        val amount: BigDecimal,
        val status: Status,
        val createdAt: Instant
    )

    data class Dto(
        val id: Int,
        val amount: Long,
        val date: String
    )

    enum class Status { HOLD, CORRECTION, CANCEL, AUTO_EXPIRED }
}

fun main() {
    val ids = listOf(1, 3, 4, 5, 6)

    val fullOperations = listOf(
        Operation(1, null, BigDecimal("10.00"), Status.HOLD, Instant.parse("2026-01-14T08:00:00Z")),
        Operation(2, 1, BigDecimal("15.00"), Status.CORRECTION, Instant.parse("2026-01-14T09:00:00Z")),

        Operation(
            3,
            null,
            BigDecimal("12.00"),
            Status.HOLD,
            Instant.parse("2026-01-15T11:00:00Z")
        ),
        Operation(
            4,
            3,
            BigDecimal("12.00"),
            Status.AUTO_EXPIRED,
            Instant.parse("2026-01-16T12:00:00Z")
        ),

        Operation(5, null, BigDecimal("55.00"), Status.HOLD, Instant.parse("2026-01-16T09:00:00Z")),
        Operation(
            6,
            5,
            BigDecimal("55.00"),
            Status.CANCEL,
            Instant.parse("2026-01-16T10:00:00Z")
        )
    )

    val displayOperations = ids.map { id ->
        val root = requireNotNull(fullOperations.find { it.id == id })

        val lastChild = fullOperations
            .filter { it.parentId == id && it.status != Status.CANCEL && it.status != Status.AUTO_EXPIRED }
            .maxByOrNull { it.createdAt }

        val amount = lastChild?.amount ?: root.amount

        val dateStr = DateTimeFormatter.ISO_LOCAL_DATE.format(
            root.createdAt.atOffset(ZoneOffset.ofHours(3)).toLocalDate()
        )

        Dto(
            id = id,
            amount = amount.toLong(),
            date = dateStr
        )
    }

    val grouped: Map<String, List<Dto>> = displayOperations
        .groupBy { it.date }
        .toSortedMap(compareByDescending { it })
        .mapValues { (_, v) -> v.sortedByDescending { it.id } }

    println("displayOperations = $displayOperations")
    println("grouped = $grouped")
}
