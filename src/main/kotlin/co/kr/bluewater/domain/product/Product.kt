package co.kr.bluewater.domain.product

import co.kr.bluewater.domain.Category
import co.kr.bluewater.domain.Photo

class Product(
    val productId: String,
    val name: String,
    val photo: Photo,
    // 상품에 카테고리가 있는게 맞나?
    val categories: MutableSet<Category>
)