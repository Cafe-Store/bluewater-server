package co.kr.bluewater.infra

import co.kr.bluewater.domain.category.Category
import co.kr.bluewater.domain.category.CategoryRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.mongodb.repository.Query
import org.springframework.stereotype.Component
import org.springframework.stereotype.Repository

@Repository
interface CategoryMongoRepository:MongoRepository<CategoryDocument, String> {
    @Query("{'code' : ?0}")
    fun findByCode(code: String): CategoryDocument
}

@Component
class CategoryRepositoryImpl(
    private val repo: CategoryMongoRepository
): CategoryRepository {
    override suspend fun findAll(): List<Category> {
        return repo.findAll()
            .map { it.category }
    }

    @Bean
    fun categoryRunner():CommandLineRunner {
        return CommandLineRunner() {
            repo.deleteAll()
            repo.saveAll(
                listOf(
                    CategoryDocument(category = Category("1234", "음식")),
                    CategoryDocument(category = Category("1235", "레저")),
                    CategoryDocument(category = Category("1236", "문화")),
                    CategoryDocument(category = Category("1237", "패션")),
                    CategoryDocument(category = Category("1238", "뷰티")),
                    CategoryDocument(category = Category("1239", "도서")),
                    CategoryDocument(category = Category("1240", "취미"))
                )
            )
        }
    }
}