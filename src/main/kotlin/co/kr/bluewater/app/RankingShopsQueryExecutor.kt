package co.kr.bluewater.app

import co.kr.bluewater.domain.RankingShop
import co.kr.bluewater.domain.RankingShopsQueryParam
import org.springframework.stereotype.Component

interface RankingShopsQueryExecutor {
    suspend fun findAllRankingShopsByLocation(param: RankingShopsQueryParam) : List<RankingShop>
}

@Component
class RankingShopsQueryExecutorMock: RankingShopsQueryExecutor {
    override suspend fun findAllRankingShopsByLocation(param: RankingShopsQueryParam): List<RankingShop> {
        return emptyList()
    }
}

