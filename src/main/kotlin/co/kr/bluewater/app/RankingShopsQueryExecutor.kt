package co.kr.bluewater.app

import co.kr.bluewater.domain.RankingShop
import co.kr.bluewater.domain.RankingShopsQueryParam
import co.kr.bluewater.domain.RankingShopsRepository
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean
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
    @ConditionalOnBean(RankingShopsRepository::class)
    fun mockRankingShopsRepository(): RankingShopsRepository {
        return object : RankingShopsRepository {
            override suspend fun findAllRankingShops(param: RankingShopsQueryParam): List<RankingShop> {
                return emptyList()
            }
        }
    }
}
