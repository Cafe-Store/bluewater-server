package co.kr.bluewater.app.ranking

import co.kr.bluewater.app.main.MainShopQueryParam
import co.kr.bluewater.domain.shop.Shop
import co.kr.bluewater.domain.shop.ShopRepository
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.stereotype.Component

@Component
class RankingShopQueryExecutor(
    private val shopRepository: ShopRepository
) {
    suspend fun execute(param: RankingShopQueryParam): List<Shop> {
        return shopRepository.findAllRankingShops(param)
            .sortedByDescending {
                it.rank
            }
    }
}

@Configuration
class RankingShopQueryBeanConfig {

    @Bean
    @ConditionalOnMissingBean(ShopRepository::class)
    fun mockShopRepository(): ShopRepository {
        return object : ShopRepository {
            override suspend fun findAllRankingShops(param: RankingShopQueryParam): List<Shop> {
                return (1..4).map {
                    Shop(shopId = Math.random().toString())
                }.toList()
            }

            override suspend fun findAllMainShops(param: MainShopQueryParam): List<Shop> {
                return (1..30).map {
                    Shop(shopId = Math.random().toString())
                }.toList()
            }
        }
    }
}
