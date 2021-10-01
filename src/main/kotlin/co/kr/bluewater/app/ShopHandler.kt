package co.kr.bluewater.app

import co.kr.bluewater.app.category.CategoryShopQueryExecutor
import co.kr.bluewater.app.ext.categoryShopQueryParam
import co.kr.bluewater.app.ext.mainShopParam
import co.kr.bluewater.app.ext.rankingShopParam
import co.kr.bluewater.app.main.MainShopQueryExecutor
import co.kr.bluewater.app.product.ShopProductQueryExecutor
import co.kr.bluewater.app.ranking.RankingShopQueryExecutor
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.ServerResponse.ok
import org.springframework.web.reactive.function.server.bodyValueAndAwait

@Component
class ShopHandler(
    // TODO : Refactoring
    private val rankingShopQueryExecutor: RankingShopQueryExecutor,
    private val mainShopQueryExecutor: MainShopQueryExecutor,
    private val categoryShopQueryExecutor: CategoryShopQueryExecutor,
    private val shopProductQueryExecutor: ShopProductQueryExecutor
) {

    suspend fun getMainShops(serverRequest: ServerRequest): ServerResponse {
        return mainShopQueryExecutor.execute(
            serverRequest.mainShopParam
        )
            .let {
                ok().bodyValueAndAwait(it)
            }
    }

    suspend fun getShopDetail(serverRequest: ServerRequest): ServerResponse {
        return mainShopQueryExecutor.execute(
            serverRequest.mainShopParam
        )
            .let {
                ok().bodyValueAndAwait(it.first())
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

    suspend fun getCategoryShops(serverRequest: ServerRequest): ServerResponse {
        return categoryShopQueryExecutor.execute(
            serverRequest.categoryShopQueryParam
        )
            .let {
                ok().bodyValueAndAwait(it)
            }
    }

    suspend fun getShopProducts(serverRequest: ServerRequest): ServerResponse {
        return shopProductQueryExecutor.execute(
            serverRequest.pathVariable("id")
        )
            .let {
                ok().bodyValueAndAwait(it)
            }
    }
}
