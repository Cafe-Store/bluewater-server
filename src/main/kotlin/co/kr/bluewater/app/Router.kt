package co.kr.bluewater.app

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.bodyValueAndAwait
import org.springframework.web.reactive.function.server.coRouter

@Configuration
class Router {

    @Bean
    fun healthCheck() = coRouter {
        GET("/health") {
            ok().bodyValueAndAwait("ok")
        }
    }

    @Bean
    fun shopRoutes(shopHandler: ShopHandler) = coRouter {
        "/shops".nest {
            GET("/", )
            GET("/ranking", shopHandler::getRankingShops)
        }
    }

}