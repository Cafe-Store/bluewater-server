package co.kr.bluewater.domain.bookmark

// 즐겨찾기는 매장만 가능한가? 상품도 가능하지 않을까...
// 입고 알림 이라던가..
class Bookmark(
    val bookmarkId: String,
    val shopId: String,
    val userId: String
)