package co.kr.bluewater.domain.shop

import co.kr.bluewater.app.main.MainShopQueryParam
import co.kr.bluewater.app.ranking.RankingShopQueryParam

interface ShopRepository {
    suspend fun findAllMainShops(param: MainShopQueryParam): List<Shop>
    suspend fun findAllRankingShops(param: RankingShopQueryParam): List<Shop>
}
