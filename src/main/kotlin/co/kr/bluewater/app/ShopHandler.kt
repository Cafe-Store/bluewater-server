package co.kr.bluewater.app

import co.kr.bluewater.app.ext.mainShopParam
import co.kr.bluewater.app.ext.rankingShopParam
import co.kr.bluewater.app.main.MainShopQueryExecutor
import co.kr.bluewater.app.ranking.RankingShopQueryExecutor
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.ServerResponse.ok
import org.springframework.web.reactive.function.server.bodyValueAndAwait

@Component
class ShopHandler(
    private val rankingShopQueryExecutor: RankingShopQueryExecutor,
    private val mainShopQueryExecutor: MainShopQueryExecutor
) {

    suspend fun getMainShops(serverRequest: ServerRequest): ServerResponse {
        return mainShopQueryExecutor.execute(
            serverRequest.mainShopParam
        )
            .let {
                ok().bodyValueAndAwait(it)
            }
    }

    suspend fun getRankingShops(serverRequest: ServerRequest): ServerResponse {
        return rankingShopQueryExecutor.execute(
            serverRequest.rankingShopParam
        )
            .let {
                ok().bodyValueAndAwait(it)
            }
    }
}
