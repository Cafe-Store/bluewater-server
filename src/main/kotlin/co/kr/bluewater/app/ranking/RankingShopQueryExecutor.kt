package co.kr.bluewater.app.ranking

import co.kr.bluewater.domain.*
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
    suspend fun execute(param: RankingShopQueryParam) : List<Shop> {
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
                return listOf(
                    Shop(shopId = "1234", name = "나이키 정자역점", rank = Rank(4.9), products = mutableSetOf()),
                    Shop(shopId = "1235", name = "아디다스 미금점", rank = Rank(4.6), products = mutableSetOf()),
                    Shop(shopId = "1236", name = "푸마 판교점", rank = Rank(5.0), products = mutableSetOf())
                )
            }
        }
    }
}
