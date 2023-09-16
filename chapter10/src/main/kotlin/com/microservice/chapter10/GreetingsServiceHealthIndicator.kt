package com.microservice.chapter10

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.actuate.health.AbstractHealthIndicator
import org.springframework.boot.actuate.health.Health
import org.springframework.stereotype.Component

@Component
class GreetingsServiceHealthIndicator : AbstractHealthIndicator() {
    @Autowired
    lateinit var greetingsService: GreetingsService

    override fun doHealthCheck(builder: Health.Builder?) {
        val lastMessage = try {
            val message = greetingsService.getGreetings()
            builder?.up()
            message
        } catch (exception : Exception) {
            builder?.down()
            "Error:$exception"
        }
        builder?.withDetail("lastMessage", lastMessage)
    }
}