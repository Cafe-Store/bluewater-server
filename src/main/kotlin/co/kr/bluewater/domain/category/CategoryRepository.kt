package co.kr.bluewater.domain.category

interface CategoryRepository {

    fun findAll(): List<Category>
}