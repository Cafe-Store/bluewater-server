package co.kr.bluewater.app.mock

import co.kr.bluewater.domain.category.Category
import co.kr.bluewater.domain.category.CategoryRepository
import co.kr.bluewater.domain.Photo
import co.kr.bluewater.domain.Price
import co.kr.bluewater.domain.product.Product
import co.kr.bluewater.domain.product.ProductRepository
import co.kr.bluewater.domain.shop.*
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.util.*
import kotlin.random.Random

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
                    name = Fixture.name(),
                    photo = Photo(Fixture.uri()),
                    categories = mutableSetOf(Category("1", "패션"))
                )
            }
        }
    }

    @Bean
    @ConditionalOnMissingBean(CategoryRepository::class)
    fun mockCategoryRepository(): CategoryRepository {
        return object : CategoryRepository {
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

    @Bean
    @ConditionalOnMissingBean(ProductRepository::class)
    fun mockProductRepository(): ProductRepository {
        return object :ProductRepository {
            override fun findAllByShopId(shopId: String): List<Product> {
                return (1..30).map {
                    fixture(shopId, Price(it.toLong()))
                }.toList()
            }

            private fun fixture(shopId: String, price: Price): Product {
                return Product(
                    name = Fixture.name(),
                    photo = Photo(Fixture.uri()),
                    categories = mutableSetOf(Category("1", "패션")),
                    price = price,
                    shopId = shopId
                )
            }
        }
    }
}

class Fixture {
    companion object {
        fun number(): Long {
            return Random.nextInt(1000, 9999).toLong()
        }

        fun name(): String {
            return UUID.randomUUID().toString().substring(0,15).replace("-","")
        }

        fun uri(): String {
            return "https://cdn.stocksnap.io/img-thumbs/960w/food-fruits_N7YQYVFWOU.jpg"
        }
    }
}