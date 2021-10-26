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
    @Query("{'data.categories' : ?0}")
    fun findAllByCategory(category: Category, page: Pageable): Page<ShopDocument>
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
                    ShopDocument(data = fixture(
                        mutableSetOf(
                            Category("1239", "도서")
                        )
                    )),
                    ShopDocument(data = fixture(
                        mutableSetOf(
                            Category("1236", "문화"),
                            Category("1239", "도서")
                        )
                    )),
                    ShopDocument(data = fixture(
                        mutableSetOf(
                            Category("1234", "음식"),
                            Category("1237", "패션")
                        )
                    )),
                    ShopDocument(data = fixture(
                        mutableSetOf(
                            Category("1235", "레저")
                        )
                    )),
                    ShopDocument(data = fixture(
                        mutableSetOf(
                            Category("1234", "음식"),
                            Category("1237", "패션")
                        )
                    )),
                    ShopDocument(data = fixture(
                        mutableSetOf(
                            Category("1234", "음식"),
                            Category("1237", "패션"),
                            Category("1238", "뷰티")
                        )
                    )),
                    ShopDocument(data = fixture(
                        mutableSetOf(
                            Category("1234", "음식"),
                            Category("1238", "뷰티")
                        )
                    )),
                    ShopDocument(data = fixture(
                        mutableSetOf(
                            Category("1240", "취미")
                        )
                    ))
                )
            )
        }
    }

    private fun fixture(categories: MutableSet<Category>): Shop {
        return Shop(
            name = Fixture.name(),
            photo = Photo(Fixture.uri()),
            categories = categories
        )
    }


    override suspend fun findAllMainShops(param: MainShopQueryParam): List<Shop> {
        return repo.findAll(PageRequest.of(param.page!!, param.size!!))
            .content
            .map { it.data }
    }

    override suspend fun findAllRankingShops(param: RankingShopQueryParam): List<Shop> {
        return repo.findAll()
            .map { it.data }
            .sortedByDescending {
                it.rank
            }
    }

    override suspend fun findAllCategoryShops(param: CategoryShopQueryParam): List<Shop> {
        val category = categoryRepo.findByCode(param.categoryCode).data
        return repo.findAllByCategory(category, PageRequest.of(param.page!!, param.size!!))
            .content
            .map { it.data }
    }

}