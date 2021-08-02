package co.kr.bluewater.domain

interface RankingShopsRepository {
    suspend fun findAllRankingShops(param: RankingShopsQueryParam): List<RankingShop>
}
