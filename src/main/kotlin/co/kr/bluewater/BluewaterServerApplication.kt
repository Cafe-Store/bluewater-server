package co.kr.bluewater

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BluewaterServerApplication

fun main(args: Array<String>) {
    runApplication<BluewaterServerApplication>(*args)
}
