package com.microservices.chapter3

data class Customer(var id: Int = 0, var name: String = "", var telephone: Telephone? = null) {
    data class Telephone(var contryCode: String = "", var telephoneNumber: String = "")
}