package co.kr.bluewater.app.product

import co.kr.bluewater.domain.product.Product
import co.kr.bluewater.domain.product.ProductRepository
import org.springframework.stereotype.Component

@Component
class ShopProductQueryExecutor(
    private val productRepository: ProductRepository
) {
    suspend fun execute(shopId: String): List<Product> {
        return productRepository.findAllByShopId(shopId)
    }
}