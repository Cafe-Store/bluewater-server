package co.kr.bluewater.app

import co.kr.bluewater.domain.*
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.stereotype.Component

@Component
class RankingShopsQueryExecutor(
    private val rankingShopsRepository: RankingShopsRepository
) {
    suspend fun execute(param: RankingShopsQueryParam) : List<RankingShop> {
        return rankingShopsRepository.findAllRankingShops(param)
            .sortedByDescending {
                it.rank
            }
    }
}

@Configuration
class RankingShopsQueryBeanConfig {

    @Bean
    @ConditionalOnMissingBean(RankingShopsRepository::class)
    fun mockRankingShopsRepository(): RankingShopsRepository {
        return object : RankingShopsRepository {
            override suspend fun findAllRankingShops(param: RankingShopsQueryParam): List<RankingShop> {
                return listOf(
                    RankingShop(ShopId(), Rank(4.9)),
                    RankingShop(ShopId(), Rank(5.0)),
                    RankingShop(ShopId(), Rank(3.7))
                )
            }
        }
    }
}
