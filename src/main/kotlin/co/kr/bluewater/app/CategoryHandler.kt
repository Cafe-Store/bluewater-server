package co.kr.bluewater.app

import co.kr.bluewater.domain.Category
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.bodyValueAndAwait

@Component
class CategoryHandler {

    suspend fun getCategories(serverRequest: ServerRequest): ServerResponse {
        val result = query()
        return ServerResponse.ok().bodyValueAndAwait(result)
    }

    private fun query(): List<Category> {
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
