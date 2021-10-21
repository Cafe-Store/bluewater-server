package co.kr.bluewater.infra

import co.kr.bluewater.domain.product.Product
import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime

@Document
data class ProductDocument(
    @Id val id: ObjectId = ObjectId.get(),
    val product: Product,
    val createdDate: LocalDateTime = LocalDateTime.now(),
    val modifiedDate: LocalDateTime = LocalDateTime.now()
)