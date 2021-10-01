package co.kr.bluewater.domain

data class Rank(
    val value: Double = ((4 until 10).random()/2).toDouble(),
    val count: Long = (100..500).random().toLong()
) : Comparable<Rank> {

    override fun compareTo(other: Rank): Int {
        return this.value.compareTo(other.value)
    }

    fun addRankPoint(rank: Rank): Rank {
        val newCount = this.count + 1
        val newValue = (this.value * this.count + rank.value) / newCount
        return Rank(value = newValue, count = newCount)
    }
}