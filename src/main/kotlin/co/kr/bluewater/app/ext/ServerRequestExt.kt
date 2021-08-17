package co.kr.bluewater.app.ext

import co.kr.bluewater.domain.Location
import co.kr.bluewater.domain.shop.MainShopQueryParam
import co.kr.bluewater.domain.shop.RankingShopQueryParam
import org.springframework.http.HttpCookie
import org.springframework.web.reactive.function.server.ServerRequest


private const val LOCATION = "location"

var ServerRequest.location: Location?
    get() = this.cookies().getFirst(LOCATION)?.let {
        Location.fromString(it.value)
    }
    set(value) = this.cookies().add(LOCATION, HttpCookie(LOCATION, value.toString()))


val ServerRequest.rankingShopParam: RankingShopQueryParam
    get() = RankingShopQueryParam(this.location)

val ServerRequest.mainShopParam: MainShopQueryParam
    get() = MainShopQueryParam(this.location)