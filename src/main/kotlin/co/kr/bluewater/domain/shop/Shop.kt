package co.kr.bluewater.domain.shop

import co.kr.bluewater.domain.Rank
import java.util.*

/**
 * Core domain model
 */
data class Shop(
    val shopId: String,
    val name: String,
    val rank: Rank,
    val products: MutableSet<String>,
    val imageUrl: String
) {
    constructor(shopId: String): this(
        shopId = shopId,
        name = UUID.randomUUID().toString().substring(0,15),
        rank = Rank(),
        products = mutableSetOf(),
        imageUrl = "https://cdn.stocksnap.io/img-thumbs/960w/food-fruits_N7YQYVFWOU.jpg"

    )

    constructor(shopId: String, name: String, rank: Rank, products: MutableSet<String>): this(
        shopId = shopId,
        name = name,
        rank = rank,
        products = products,
        imageUrl = "https://cdn.stocksnap.io/img-thumbs/960w/food-fruits_N7YQYVFWOU.jpg"
    )

}