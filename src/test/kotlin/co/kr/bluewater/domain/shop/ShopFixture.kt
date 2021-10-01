package co.kr.bluewater.domain.shop

import co.kr.bluewater.domain.category.Category
import co.kr.bluewater.domain.Photo
import java.util.*

fun shopFixture(): Shop {
    return Shop(
        name = UUID.randomUUID().toString().substring(0,15),
        photo = Photo("https://cdn.stocksnap.io/img-thumbs/960w/food-fruits_N7YQYVFWOU.jpg"),
        categories = mutableSetOf(Category("1", "패션"))
    )
}