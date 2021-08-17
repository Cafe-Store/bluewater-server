package co.kr.bluewater.domain.order

class Order(
    val orderId: String,
    val products: MutableSet<String>,
    val buyer: Buyer
)