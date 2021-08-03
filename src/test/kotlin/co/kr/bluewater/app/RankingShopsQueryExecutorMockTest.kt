package co.kr.bluewater.app

import co.kr.bluewater.domain.RankingShopsQueryParam
import co.kr.bluewater.domain.userFixture
import kotlinx.coroutines.test.runBlockingTest
import org.junit.jupiter.api.Test

internal class RankingShopsQueryExecutorMockTest {

    @Test
    fun `랭킹매장이 없는 경우 빈 컬렉션을 반환한다`() = runBlockingTest {
        val executor = RankingShopsQueryExecutorMock()
        val param = RankingShopsQueryParam(
            user = userFixture()
        )

        val actual = executor.findAllRankingShopsByLocation(param = param)

        assert(actual.isEmpty())
    }

    @Test
    fun `랭킹매장은 평점이 높은 순으로 나열된다`() {

    }

}