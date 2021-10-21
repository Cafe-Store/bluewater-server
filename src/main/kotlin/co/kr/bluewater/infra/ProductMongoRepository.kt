package co.kr.bluewater.infra

import co.kr.bluewater.domain.Fixture
import co.kr.bluewater.domain.Photo
import co.kr.bluewater.domain.Price
import co.kr.bluewater.domain.category.Category
import co.kr.bluewater.domain.product.Product
import co.kr.bluewater.domain.product.ProductRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Component
import org.springframework.stereotype.Repository

@Repository
interface ProductMongoRepository: MongoRepository<ProductDocument, String> {
}

@Component
class ProductRepositoryImpl(
    private val repo: ProductMongoRepository
): ProductRepository {

    @Bean
    fun productRunner(): CommandLineRunner {
        return CommandLineRunner() {
            repo.deleteAll()
            repo.saveAll(
                (1..30).map {
                    ProductDocument(product = fixture(it.toString(), Price(it.toLong())))
                }.toList()
            )
        }
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

    override fun findAllByShopId(shopId: String): List<Product> {
        TODO("Not yet implemented")
    }
}