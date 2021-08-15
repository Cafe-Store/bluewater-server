package co.kr.bluewater.app.main

import co.kr.bluewater.domain.shop.Shop
import co.kr.bluewater.domain.shop.ShopRepository
import org.springframework.stereotype.Component

@Component
class MainShopQueryExecutor(
    private val shopRepository: ShopRepository
) {
    suspend fun execute(param: MainShopQueryParam): List<Shop> {
        return shopRepository.findAllMainShops(param)
    }
}