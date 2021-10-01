package co.kr.bluewater.domain

interface CategoryRepository {

    fun findAll(): List<Category>
}