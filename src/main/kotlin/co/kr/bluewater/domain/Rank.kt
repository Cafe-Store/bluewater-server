package co.kr.bluewater.domain

data class Rank(
    var value: Double = 0.0,
    val count: Long
) : Comparable<Rank> {

    constructor(value: Double): this(
        value = value,
        count = 500
    )


    override fun compareTo(other: Rank): Int {
        return this.value.compareTo(other.value)
    }
}