package co.kr.bluewater.domain.shop

import co.kr.bluewater.domain.Rank

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

    constructor(shopId: String, name: String, rank: Rank, products: MutableSet<String>): this(
        shopId = shopId,
        name = name,
        rank = rank,
        products = products,
        imageUrl = "https://cdn.stocksnap.io/img-thumbs/960w/food-fruits_N7YQYVFWOU.jpg"
    )

}