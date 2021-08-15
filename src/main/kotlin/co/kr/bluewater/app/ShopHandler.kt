package co.kr.bluewater.app

import co.kr.bluewater.app.ext.rankingShopParam
import co.kr.bluewater.app.ranking.RankingShopQueryExecutor
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
            serverRequest.rankingShopParam
        )
            .let {
                ok().bodyValueAndAwait(it)
            }
    }
}
