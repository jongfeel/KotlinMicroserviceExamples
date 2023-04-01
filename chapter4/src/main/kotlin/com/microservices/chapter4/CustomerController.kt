package com.microservices.chapter4

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class CustomerController {
    @GetMapping(value = ["/customer/{id}"])
    fun getCustomer(@PathVariable id: Int) = Customer(id, "customer $id")
}