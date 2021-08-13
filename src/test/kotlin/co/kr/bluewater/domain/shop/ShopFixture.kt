package co.kr.bluewater.domain.shop

import co.kr.bluewater.domain.Rank
import java.util.*

fun shopFixture(): Shop {
    return Shop(
        shopId = UUID.randomUUID().toString().replace("-", ""),
        name = "",
        rank = Rank(4.1),
        products = mutableSetOf(
            UUID.randomUUID().toString().replace("-", "")
        )
    )
}