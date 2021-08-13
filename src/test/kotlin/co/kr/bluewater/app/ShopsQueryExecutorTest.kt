package co.kr.bluewater.app

import co.kr.bluewater.app.ranking.RankingShopQueryExecutor
import co.kr.bluewater.app.ranking.RankingShopQueryParam
import co.kr.bluewater.domain.*
import co.kr.bluewater.domain.shop.Shop
import co.kr.bluewater.domain.shop.ShopRepository
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

}

class ShopRepositoryEmptyStub : ShopRepository {
    override suspend fun findAllRankingShops(param: RankingShopQueryParam): List<Shop> {
        return emptyList()
    }
}

class ShopRepositoryStub : ShopRepository {
    override suspend fun findAllRankingShops(param: RankingShopQueryParam): List<Shop> {
        return listOf(
            Shop(shopId = "1234", name = "나이키 정자역점", rank = Rank(4.9), products = mutableSetOf()),
            Shop(shopId = "1235", name = "아디다스 미금점", rank = Rank(4.6), products = mutableSetOf()),
            Shop(shopId = "1236", name = "푸마 판교점", rank = Rank(5.0), products = mutableSetOf())
        )
    }
}