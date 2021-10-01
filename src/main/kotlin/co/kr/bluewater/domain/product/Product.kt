package co.kr.bluewater.domain.product

import co.kr.bluewater.domain.Photo
import co.kr.bluewater.domain.Price
import co.kr.bluewater.domain.category.Category
import java.util.*

class Product(
    val productId: String,
    val name: String,
    val photo: Photo,
    val price: Price,
    val shopId: String,
    val categories: MutableSet<Category>
) {
    constructor(name: String, photo: Photo, price: Price, shopId: String, categories: MutableSet<Category>):this(
        productId = UUID.randomUUID().toString().substring(0,15), // TODO : ID 생성도 코드 추출하자.
        name = name,
        photo = photo,
        price = price,
        shopId = shopId,
        categories = categories
    )
}