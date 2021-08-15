package co.kr.bluewater.domain

import com.fasterxml.jackson.databind.ObjectMapper

data class Location(
    val postcode: String
) {
    companion object {
        fun fromString(str: String): Location {
            return ObjectMapper().readValue(str, Location::class.java)
        }
    }
}
