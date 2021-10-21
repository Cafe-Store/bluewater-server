package co.kr.bluewater.domain.shop

import co.kr.bluewater.domain.*
import co.kr.bluewater.domain.category.Category
import java.util.*

/**
 * Core domain model
 */
class Shop(
    val shopId: String,
    val name: String,
    val address: Address,
    val tel: TelephoneNumber,
    val businessNumber: BusinessNumber,
    val rank: Rank,
    val products: MutableSet<String>,
    val photos: MutableSet<ShopPhoto>,
    val owner: Owner,
    val officeHours: String,
    val notice: String,
    val categories: MutableSet<Category>
) {

    constructor(name: String, photo: Photo, categories: MutableSet<Category>):this(
        shopId = UUID.randomUUID().toString().replace("-", ""),
        name = name,
        address = Address(
            postcode = "12345",
            street = "경기도 성남시 분당구 판교역로 152",
            detail = "알파돔타워"
        ),
        officeHours = "월-목: 10:00 ~ 23:00\n금-일: 10:30 ~ 23:00",
        notice = "매장의 공지사항은 이렇습니다.\n어쩌구 저쩌구 이러쿵 저러쿵 입니다.\n그렇지만 맛은 좋습니다.\n하지만 신발가게라서 드시면 안됩니다.",
        owner = Owner("김사장"),
        tel = TelephoneNumber("031-1234-1234"),
        businessNumber = BusinessNumber("111-80-12323"),
        rank = Rank(),
        products = mutableSetOf(),
        photos = mutableSetOf(ShopPhoto(main = true, photo = photo), ShopPhoto(photo = photo), ShopPhoto(photo = photo)),
        categories = categories
    )
}