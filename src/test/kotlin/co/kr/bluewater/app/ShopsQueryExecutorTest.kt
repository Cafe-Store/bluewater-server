package co.kr.bluewater.app

import co.kr.bluewater.app.main.MainShopQueryParam
import co.kr.bluewater.app.ranking.RankingShopQueryExecutor
import co.kr.bluewater.app.ranking.RankingShopQueryParam
import co.kr.bluewater.domain.*
import co.kr.bluewater.domain.shop.Shop
import co.kr.bluewater.domain.shop.ShopRepository
import co.kr.bluewater.domain.shop.shopFixture
import kotlinx.coroutines.test.runBlockingTest
import org.junit.jupiter.api.Test

internal class ShopsQueryExecutorTest {

    @Test
    fun `랭킹매장이 없는 경우 빈 컬렉션을 반환한다`() = runBlockingTest {
        val executor = RankingShopQueryExecutor(
            shopRepository = ShopRepositoryEmptyStub()
        )
        val param = RankingShopQueryParam(
            location = Location("12345")
        )

        val actual = executor.execute(param = param)

        assert(actual.isEmpty())
    }

    @Test
    fun `랭킹매장이 있으면 평점이 높은 순으로 나열된다`() = runBlockingTest {
        val executor = RankingShopQueryExecutor(
            shopRepository = ShopRepositoryStub()
        )
        val param = RankingShopQueryParam(
            location = Location("12345")
        )

        val actual = executor.execute(param = param)

        assert(actual.isNotEmpty())
        val sorted = actual.sortedByDescending {
            it.rank
        }
        assert(sorted == actual)
    }

    @Test
    fun `test`() {
        println(shopFixture().toString())
    }

}

class ShopRepositoryEmptyStub : ShopRepository {
    override suspend fun findAllRankingShops(param: RankingShopQueryParam): List<Shop> {
        return emptyList()
    }

    override suspend fun findAllMainShops(param: MainShopQueryParam): List<Shop> {
        return emptyList()
    }
}

class ShopRepositoryStub : ShopRepository {
    override suspend fun findAllRankingShops(param: RankingShopQueryParam): List<Shop> {
        return listOf(
            shopFixture(),
            shopFixture(),
            shopFixture()
        )
    }

    override suspend fun findAllMainShops(param: MainShopQueryParam): List<Shop> {
        return listOf(
            shopFixture(),
            shopFixture(),
            shopFixture()
        )
    }
}