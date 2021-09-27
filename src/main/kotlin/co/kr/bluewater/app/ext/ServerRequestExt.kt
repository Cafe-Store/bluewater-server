package co.kr.bluewater.app.ext

import co.kr.bluewater.domain.Location
import co.kr.bluewater.domain.shop.CategoryShopQueryParam
import co.kr.bluewater.domain.shop.MainShopQueryParam
import co.kr.bluewater.domain.shop.RankingShopQueryParam
import org.springframework.http.HttpCookie
import org.springframework.web.reactive.function.server.ServerRequest


private const val LOCATION = "location"
private const val CATEGORY_CODE_PARAM_NAME = "code"
private const val DEFAULT_CATEGORY_CODE = "1234"

var ServerRequest.location: Location?
    get() = this.cookies().getFirst(LOCATION)?.let {
        Location.fromString(it.value)
    }
    set(value) = this.cookies().add(LOCATION, HttpCookie(LOCATION, value.toString()))


val ServerRequest.rankingShopParam: RankingShopQueryParam
    get() = RankingShopQueryParam(this.location)

val ServerRequest.mainShopParam: MainShopQueryParam
    get() = MainShopQueryParam(this.location)

val ServerRequest.categoryShopQueryParam: CategoryShopQueryParam
    get() = CategoryShopQueryParam(this.location,
        this.queryParam(CATEGORY_CODE_PARAM_NAME).orElse(DEFAULT_CATEGORY_CODE))