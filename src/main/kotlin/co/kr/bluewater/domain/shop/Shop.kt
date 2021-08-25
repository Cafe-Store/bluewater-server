package co.kr.bluewater.domain.shop

import co.kr.bluewater.domain.Category
import co.kr.bluewater.domain.Photo
import co.kr.bluewater.domain.Rank
import java.util.*

/**
 * Core domain model
 */
class Shop(
    val shopId: String,
    val name: String,
    val rank: Rank,
    val products: MutableSet<String>,
    val photo: Photo,
    val owner: Owner? = null,
    val categories: MutableSet<Category>? = null
) {
    constructor(shopId: String): this(
        shopId = shopId,
        name = UUID.randomUUID().toString().substring(0,15),
        rank = Rank(),
        products = mutableSetOf(),
        photo = Photo("https://cdn.stocksnap.io/img-thumbs/960w/food-fruits_N7YQYVFWOU.jpg"),
        categories = mutableSetOf(Category("1", "패션"))
    )

    constructor(shopId: String, name: String, rank: Rank, products: MutableSet<String>): this(
        shopId = shopId,
        name = name,
        rank = rank,
        products = products,
        photo = Photo("https://cdn.stocksnap.io/img-thumbs/960w/food-fruits_N7YQYVFWOU.jpg"),
        categories = mutableSetOf(Category("1", "패션"))
    )

}