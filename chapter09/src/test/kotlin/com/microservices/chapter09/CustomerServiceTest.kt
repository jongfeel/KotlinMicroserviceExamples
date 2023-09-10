package com.microservices.chapter09

import org.junit.jupiter.api.Assertions.assertEquals
import org.amshove.kluent.*
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class CustomerServiceTest {
    @Autowired
    lateinit var customerService: CustomerService
    @Test
    fun `we should get a customer with a valid id`() {
        val customer = customerService.getCustomer(1)
        customer.`should not be null`()
        customer?.name `should be` "Kotlin"
        assertEquals(customer?.name, "Kotlin")
    }

    @Test
    fun `we should get all customers`() {
        val customers = customerService.getAllCustomers()
        customers.size `should be equal to` 3
        customers.size `should be greater than` 0
        customers.size `should be less or equal to` 3
        customers.size `should be in range` 1..3
    }
}