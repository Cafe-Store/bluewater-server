package co.kr.bluewater.domain.review

import co.kr.bluewater.domain.Photo

class Review(
    val reviewId: String,
    val writer: Writer,
    val orderId: String,
    val content: String,
    val photos: MutableSet<Photo>,
    val score: Score
)