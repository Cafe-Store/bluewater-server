package co.kr.bluewater.domain

data class Rank(
    val value: Double = ((4 until 10).random()/2).toDouble(),
    val count: Long = (100..500).random().toLong()
) : Comparable<Rank> {


    override fun compareTo(other: Rank): Int {
        return this.value.compareTo(other.value)
    }
}