package co.kr.bluewater.app

import co.kr.bluewater.domain.category.Category
import co.kr.bluewater.domain.category.CategoryRepository
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.bodyValueAndAwait

@Component
class CategoryHandler(
    private val categoryRepository: CategoryRepository
) {

    suspend fun getCategories(serverRequest: ServerRequest): ServerResponse {
        val result = query()
        return ServerResponse.ok().bodyValueAndAwait(result)
    }

    private suspend fun query(): List<Category> {
        return categoryRepository.findAll()
    }
}
