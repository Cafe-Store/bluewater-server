package co.kr.bluewater.app.mock

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class FixtureTest {


    @Test
    fun `number 생성 테스트`() {
        val number = Fixture.number()
        println(number)
        assert(number > -1)
    }

    @Test
    fun `name 생성 테스트`() {
        val name = Fixture.name()
        println(name)
        assert(name.isNotBlank())
    }

    @Test
    fun `uri 생성 테스트`() {
        val uri = Fixture.uri()
        println(uri)
        assert(uri.isNotBlank())
    }
}