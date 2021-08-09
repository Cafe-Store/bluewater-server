package co.kr.bluewater.domain

data class RankingShop(
    val shopId: ShopId,
    val rank: Rank

)

class ShopId

data class Rank(
    var value: Double = 0.0
) : Comparable<Rank> {



    override fun compareTo(other: Rank): Int {
        return this.value.compareTo(other.value)
    }
}