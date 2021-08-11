package co.kr.bluewater.domain.shop

import co.kr.bluewater.app.ranking.RankingShopQueryParam

interface ShopRepository {
    suspend fun findAllRankingShops(param: RankingShopQueryParam): List<Shop>
}
