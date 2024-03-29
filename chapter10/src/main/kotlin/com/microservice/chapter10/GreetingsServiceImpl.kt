package com.microservice.chapter10

import org.springframework.stereotype.Service
import java.util.*

@Service
class GreetingsServiceImpl : GreetingsService {
    companion object {
        private val greetingsMessages = arrayOf("Hello", "Ola", "Namaste", "Hola")
    }

    fun random(max: Int): Int = Random().nextInt(max) + 1

    override fun getGreetings(): String = greetingsMessages[random(4)]
}