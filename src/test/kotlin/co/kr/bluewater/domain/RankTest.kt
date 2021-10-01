package co.kr.bluewater.domain

import org.junit.jupiter.api.Test

internal class RankTest {

    @Test
    fun compareTo() {
        val rank1 = Rank(value = 5.0, count = 1)
        val rank2 = Rank(value = 4.0, count = 1)

        assert(rank1 > rank2)

        val rank3 = Rank(value = 5.0, count = 1)
        val rank4 = Rank(value = 5.0, count = 1)

        assert(rank3 == rank4)

        val rank5 = Rank(value = 4.0, count = 1)
        val rank6 = Rank(value = 5.0, count = 1)

        assert(rank5 < rank6)
    }

    @Test
    fun addRankPoint() {
        val rank1 = Rank(value = 5.0, count = 1)
        val rank2 = Rank(value = 4.0, count = 1)
        val newRank = rank1.addRankPoint(rank2)

        assert(newRank.value == 4.5)
        assert(newRank.count == 2L)

        val newRank2 = newRank.addRankPoint(rank2)

        assert(newRank2.value == 4.333333333333333)
        assert(newRank2.count == 3L)

    }
}