package co.kr.bluewater.domain

import co.kr.bluewater.domain.user.User

fun userFixture(): User {
    return User(
        Location("12345")
    )
}