package co.kr.bluewater.domain

data class Category(
    val code: String,
    val name: String,
    val image: String
) {
    constructor(code: String, name: String):this(
        code = code,
        name = name,
        image = "https://cdn.stocksnap.io/img-thumbs/960w/food-fruits_N7YQYVFWOU.jpg"
    )
}