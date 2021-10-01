package co.kr.bluewater.app.ranking

import co.kr.bluewater.domain.shop.*
import org.springframework.stereotype.Component

@Component
class RankingShopQueryExecutor(
    private val shopRepository: ShopRepository
) {
    suspend fun execute(param: RankingShopQueryParam): List<Shop> {
        return shopRepository.findAllRankingShops(param)
            .sortedByDescending {
                it.rank
            }
    }
}