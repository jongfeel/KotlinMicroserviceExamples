package com.microservices.chapter5

import jakarta.annotation.PostConstruct
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.core.ReactiveMongoOperations
import org.springframework.stereotype.Component

@Component
class DatabaseInitializer {
    @Autowired
    lateinit var customerRepository: CustomerRepository

    companion object {
        val initialCustomers = listOf(
            Customer(1, "Kotlin"),
            Customer(2, "Spring"),
            Customer(3, "Microservice", Customer.Telephone("+44", "7123456789"))
        )
    }
    @PostConstruct
    fun initData() {
        customerRepository.saveAll(initialCustomers).subscribe {
            println("Default customers created")
        }
    }
}