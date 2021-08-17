package co.kr.bluewater.domain.shop

import co.kr.bluewater.domain.Location

interface ShopRepository {
    suspend fun findAllMainShops(param: MainShopQueryParam): List<Shop>
    suspend fun findAllRankingShops(param: RankingShopQueryParam): List<Shop>
}


data class MainShopQueryParam(
    val location: Location?,
    val page: Int? = 0,
    val size: Int? = 10
)


data class RankingShopQueryParam(
    val location: Location?
)