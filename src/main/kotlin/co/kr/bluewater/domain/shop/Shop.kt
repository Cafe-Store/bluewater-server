package co.kr.bluewater.domain.shop

import co.kr.bluewater.domain.Rank

/**
 * Core domain model
 */
data class Shop(
    val shopId: String,
    val name: String,
    val rank: Rank,
    val products: MutableSet<String>
)