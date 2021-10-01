package co.kr.bluewater.app.mock

import co.kr.bluewater.domain.Category
import co.kr.bluewater.domain.CategoryRepository
import co.kr.bluewater.domain.Photo
import co.kr.bluewater.domain.shop.*
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.util.*

@Configuration
class RankingShopQueryBeanConfig {

    @Bean
    @ConditionalOnMissingBean(ShopRepository::class)
    fun mockShopRepository(): ShopRepository {
        return object : ShopRepository {
            override suspend fun findAllRankingShops(param: RankingShopQueryParam): List<Shop> {
                return (1..4).map {
                    fixture()
                }.toList()
            }

            override suspend fun findAllMainShops(param: MainShopQueryParam): List<Shop> {
                return (1..30).map {
                    fixture()
                }.toList()
            }

            override suspend fun findAllCategoryShops(param: CategoryShopQueryParam): List<Shop> {
                return (1..30).map {
                    fixture()
                }.toList()
            }

            private fun fixture(): Shop {
                return Shop(
                    name = UUID.randomUUID().toString().substring(0,15),
                    photo = Photo("https://cdn.stocksnap.io/img-thumbs/960w/food-fruits_N7YQYVFWOU.jpg"),
                    categories = mutableSetOf(Category("1", "패션"))
                )
            }
        }
    }

    @Bean
    @ConditionalOnMissingBean(CategoryRepository::class)
    fun mockCategoryRepository(): CategoryRepository {
        return object :CategoryRepository {
            override fun findAll(): List<Category> {
                return arrayListOf(
                    Category("1234", "음식"),
                    Category("1235", "레저"),
                    Category("1236", "문화"),
                    Category("1237", "패션"),
                    Category("1238", "뷰티"),
                    Category("1239", "도서"),
                    Category("1240", "취미"),
                )
            }
        }
    }
}