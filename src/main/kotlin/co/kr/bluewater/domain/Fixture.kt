package co.kr.bluewater.domain

import java.util.*
import kotlin.random.Random

class Fixture {
    companion object {
        fun number(): Long {
            return Random.nextInt(1000, 9999).toLong()
        }

        fun name(): String {
            return UUID.randomUUID().toString().substring(0,15).replace("-","")
        }

        fun uri(): String {
            return "https://cdn.stocksnap.io/img-thumbs/960w/food-fruits_N7YQYVFWOU.jpg"
        }
    }
}