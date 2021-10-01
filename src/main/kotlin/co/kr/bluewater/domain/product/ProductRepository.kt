package co.kr.bluewater.domain.product

interface ProductRepository {
    fun findAllByShopId(shopId: String): List<Product>
}