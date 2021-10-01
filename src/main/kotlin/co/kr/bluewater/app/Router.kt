package co.kr.bluewater.app

import kotlinx.coroutines.FlowPreview
import org.springdoc.core.annotations.RouterOperation
import org.springdoc.core.annotations.RouterOperations
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.bind.annotation.RequestMethod
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
    @FlowPreview
    @RouterOperations(
        RouterOperation(path = "/categories", method = arrayOf(RequestMethod.GET), beanClass = CategoryHandler::class, beanMethod = "getCategories"),
    )
    @Bean
    fun categories(categoryHandler: CategoryHandler) = coRouter {
        "/categories".nest {
            GET("", categoryHandler::getCategories)
        }
    }

    @FlowPreview
    @RouterOperations(
        RouterOperation(path = "/shops", method = arrayOf(RequestMethod.GET), beanClass = ShopHandler::class, beanMethod = "getMainShops"),
        RouterOperation(path = "/shops/ranking", method = arrayOf(RequestMethod.GET), beanClass = ShopHandler::class, beanMethod = "getRankingShops"),
        RouterOperation(path = "/shops/category", method = arrayOf(RequestMethod.GET), beanClass = ShopHandler::class, beanMethod = "getCategoryShops"),
        RouterOperation(path = "/shops/{id}", method = arrayOf(RequestMethod.GET), beanClass = ShopHandler::class, beanMethod = "getShopDetail"),
        RouterOperation(path = "/shops/{id}/products", method = arrayOf(RequestMethod.GET), beanClass = ShopHandler::class, beanMethod = "getShopProducts")
    )
    @Bean
    fun shopRoutes(shopHandler: ShopHandler) = coRouter {
        "/shops".nest {
            GET("", shopHandler::getMainShops)
            GET("/ranking", shopHandler::getRankingShops)
            GET("/category", shopHandler::getCategoryShops)
            GET("/{id}", shopHandler::getShopDetail)
            GET("/{id}/products", shopHandler::getShopProducts)
        }
    }
}