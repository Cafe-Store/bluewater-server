package co.kr.bluewater.infra

import co.kr.bluewater.domain.category.Category
import co.kr.bluewater.domain.product.Product
import co.kr.bluewater.domain.shop.Shop
import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime

abstract class BaseDocument<T>(
    @Id var id: ObjectId = ObjectId.get(),
    var data: T,
    var createdDate: LocalDateTime = LocalDateTime.now(),
    var modifiedDate: LocalDateTime = LocalDateTime.now()
)

@Document(collection = "products")
class ProductDocument(data: Product): BaseDocument<Product>(data = data)

@Document(collection = "shops")
class ShopDocument(data: Shop) : BaseDocument<Shop>(data = data)

@Document(collection = "categories")
class CategoryDocument(data: Category) : BaseDocument<Category>(data = data)