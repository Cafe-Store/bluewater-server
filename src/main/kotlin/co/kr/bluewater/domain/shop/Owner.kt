package co.kr.bluewater.domain.shop

import java.util.*

class Owner(
    val ownerId: String,
    val name: String
) {
    constructor(name: String): this(
        ownerId = UUID.randomUUID().toString().replace("-", ""),
        name = name
    )
}