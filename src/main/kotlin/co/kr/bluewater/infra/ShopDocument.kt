package co.kr.bluewater.infra

import co.kr.bluewater.domain.shop.Shop
import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime

@Document
data class ShopDocument(
    @Id val id: ObjectId = ObjectId.get(),
    val shop: Shop,
    val createdDate: LocalDateTime = LocalDateTime.now(),
    val modifiedDate: LocalDateTime = LocalDateTime.now()
)