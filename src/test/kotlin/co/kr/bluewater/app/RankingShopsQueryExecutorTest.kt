package co.kr.bluewater.app

import co.kr.bluewater.domain.*
import kotlinx.coroutines.test.runBlockingTest
import org.junit.jupiter.api.Test

internal class RankingShopsQueryExecutorTest {

    @Test
    fun `랭킹매장이 없는 경우 빈 컬렉션을 반환한다`() = runBlockingTest {
        val executor = RankingShopsQueryExecutor(
            rankingShopsRepository = RankingShopRepositoryEmptyStub()
        )
        val param = RankingShopsQueryParam(
            user = userFixture()
        )

        val actual = executor.execute(param = param)

        assert(actual.isEmpty())
    }

    @Test
    fun `랭킹매장이 있으면 평점이 높은 순으로 나열된다`() = runBlockingTest {
        val executor = RankingShopsQueryExecutor(
            rankingShopsRepository = RankingShopRepositoryStub()
        )
        val param = RankingShopsQueryParam(
            user = userFixture()
        )

        val actual = executor.execute(param = param)

        assert(actual.isNotEmpty())
        val sorted = actual.sortedByDescending {
            it.rank
        }
        assert(sorted == actual)
    }

}

class RankingShopRepositoryEmptyStub : RankingShopsRepository {
    override suspend fun findAllRankingShops(param: RankingShopsQueryParam): List<RankingShop> {
        return emptyList()
    }
}

class RankingShopRepositoryStub : RankingShopsRepository {
    override suspend fun findAllRankingShops(param: RankingShopsQueryParam): List<RankingShop> {
        return listOf(
            RankingShop(ShopId(), Rank(4.9)),
            RankingShop(ShopId(), Rank(4.6)),
            RankingShop(ShopId(), Rank(5.0))
        )
    }
}