package co.kr.bluewater.domain.shop

import co.kr.bluewater.domain.category.Category
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
    val photos: MutableSet<ShopPhoto>,
    val owner: Owner? = null,
    val categories: MutableSet<Category>? = null
) {

    constructor(name: String, photo: Photo, categories: MutableSet<Category>):this(
        shopId = UUID.randomUUID().toString().substring(0,15),
        name = name,
        rank = Rank(),
        products = mutableSetOf(),
        photos = mutableSetOf(ShopPhoto(main = true, photo = photo)),
        categories = categories
    )
}