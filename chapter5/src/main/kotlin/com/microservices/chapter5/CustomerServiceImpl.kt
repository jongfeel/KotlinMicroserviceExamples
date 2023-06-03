package com.microservices.chapter5

import org.springframework.beans.factory.annotation.Autowired
import reactor.core.publisher.Mono

class CustomerServiceImpl : CustomerService {
    @Autowired
    lateinit var customerRepository: CustomerRepository
    override fun getCustomer(id: Int): Mono<Customer> = customerRepository.findById(id)
}