package co.kr.bluewater.domain.shop

import co.kr.bluewater.domain.Rank
import java.util.*

fun shopFixture(): Shop {
    return Shop(
        shopId = UUID.randomUUID().toString().replace("-", ""),
        name = UUID.randomUUID().toString().replace("-", ""),
        rank = Rank(),
        products = mutableSetOf(
            UUID.randomUUID().toString().replace("-", "")
        )
    )
}