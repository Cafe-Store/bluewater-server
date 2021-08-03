package co.kr.bluewater.domain

import org.junit.jupiter.api.Assertions.*

fun userFixture(): User {
    return User(
        Location("12345")
    )
}