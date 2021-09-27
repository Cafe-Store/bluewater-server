package co.kr.bluewater.app.category

import co.kr.bluewater.domain.shop.CategoryShopQueryParam
import co.kr.bluewater.domain.shop.Shop
import co.kr.bluewater.domain.shop.ShopRepository
import org.springframework.stereotype.Component

@Component
class CategoryShopQueryExecutor(
    val shopRepository: ShopRepository
) {

    suspend fun execute(param: CategoryShopQueryParam): List<Shop> {
        return shopRepository.findAllCategoryShops(param)
    }


}