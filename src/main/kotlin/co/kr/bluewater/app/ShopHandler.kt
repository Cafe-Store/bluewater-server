package co.kr.bluewater.app

import co.kr.bluewater.domain.Location
import co.kr.bluewater.domain.RankingShopsQueryParam
import co.kr.bluewater.domain.User
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.*
import org.springframework.web.reactive.function.server.ServerResponse.ok

@Component
class ShopHandler(
    private val rankingShopsQueryExecutor: RankingShopsQueryExecutor
) {

    suspend fun getRankingShops(serverRequest: ServerRequest): ServerResponse {
        val user = serverRequest.awaitPrincipal()?.let {
            it as User
        }?:User(location = Location("12345"))

        return rankingShopsQueryExecutor.execute(
            RankingShopsQueryParam(user = user)
        )
            .let {
                ok().bodyValueAndAwait(it)
            }
    }
}
