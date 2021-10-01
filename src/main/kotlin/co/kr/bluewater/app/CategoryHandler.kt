package co.kr.bluewater.app

import co.kr.bluewater.domain.Category
import co.kr.bluewater.domain.CategoryRepository
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

    private fun query(): List<Category> {
        return categoryRepository.findAll()
    }
}
