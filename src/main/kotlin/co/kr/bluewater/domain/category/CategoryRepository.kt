package co.kr.bluewater.domain.category

interface CategoryRepository {
    suspend fun findAll(): List<Category>
}