package co.kr.bluewater.app

import co.kr.bluewater.app.ranking.RankingShopQueryParam
import co.kr.bluewater.app.ranking.RankingShopQueryExecutor
import co.kr.bluewater.domain.Location
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.ServerResponse.ok
import org.springframework.web.reactive.function.server.bodyValueAndAwait

@Component
class ShopHandler(
    private val rankingShopQueryExecutor: RankingShopQueryExecutor
) {

    suspend fun getRankingShops(serverRequest: ServerRequest): ServerResponse {
        return rankingShopQueryExecutor.execute(
            RankingShopQueryParam(location = Location("12345"))
        )
            .let {
                ok().bodyValueAndAwait(it)
            }
    }
}
