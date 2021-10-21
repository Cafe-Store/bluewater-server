package co.kr.bluewater.infra

import co.kr.bluewater.domain.Fixture
import co.kr.bluewater.domain.Photo
import co.kr.bluewater.domain.category.Category
import co.kr.bluewater.domain.shop.*
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.mongodb.repository.Query
import org.springframework.stereotype.Component
import org.springframework.stereotype.Repository

@Repository
interface ShopMongoRepository:MongoRepository<ShopDocument, String> {
    @Query("{'shop.categories' : { in: [?0] }}")
    fun findAllByCategoriesContains(category: Category, page: Pageable): Page<ShopDocument>
}

@Component
class ShopRepositoryImpl(
    private val repo: ShopMongoRepository,
    private val categoryRepo: CategoryMongoRepository
): ShopRepository {

    @Bean
    fun shopRunner(): CommandLineRunner {
        return CommandLineRunner() {
            repo.deleteAll()
            repo.saveAll(
                listOf(
                    ShopDocument(shop = fixture()),
                    ShopDocument(shop = fixture()),
                    ShopDocument(shop = fixture()),
                    ShopDocument(shop = fixture()),
                    ShopDocument(shop = fixture()),
                    ShopDocument(shop = fixture()),
                    ShopDocument(shop = fixture())
                )
            )
        }
    }

    private fun fixture(): Shop {
        return Shop(
            name = Fixture.name(),
            photo = Photo(Fixture.uri()),
            categories = mutableSetOf(Category("1237", "패션"))
        )
    }


    override suspend fun findAllMainShops(param: MainShopQueryParam): List<Shop> {
        return repo.findAll(PageRequest.of(param.page!!, param.size!!))
            .content
            .map { it.shop }
    }

    override suspend fun findAllRankingShops(param: RankingShopQueryParam): List<Shop> {
        return repo.findAll()
            .map { it.shop }
            .sortedByDescending {
                it.rank
            }
    }

    override suspend fun findAllCategoryShops(param: CategoryShopQueryParam): List<Shop> {
        val category = categoryRepo.findByCode(param.categoryCode).category
        return repo.findAllByCategoriesContains(category, PageRequest.of(param.page!!, param.size!!))
            .content
            .map { it.shop }
    }

}