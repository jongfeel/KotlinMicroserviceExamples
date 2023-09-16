package com.microservice.chapter10

import org.springframework.boot.actuate.web.exchanges.HttpExchangeRepository
import org.springframework.boot.actuate.web.exchanges.InMemoryHttpExchangeRepository
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class ActuatorHttpExchangeConfiguration {
    @Bean
    fun httpTraceRepository(): HttpExchangeRepository = InMemoryHttpExchangeRepository()
}