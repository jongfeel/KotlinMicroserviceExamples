package com.microservice.chapter10

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jmx.export.annotation.ManagedOperation
import org.springframework.jmx.export.annotation.ManagedOperationParameter
import org.springframework.jmx.export.annotation.ManagedOperationParameters
import org.springframework.jmx.export.annotation.ManagedResource
import org.springframework.stereotype.Component

@Component
@ManagedResource(objectName = "com.microservices:type=greegins,name=GetHello", description = "Get greetings")
class GreetingsMBean {
    @Autowired
    lateinit var greetingsService: GreetingsService

    @ManagedOperation(description = "Returns a greeting message")
    @ManagedOperationParameters(ManagedOperationParameter(description = "provide a name", name = "name"))
    fun hello(name: String) = try {
        greetingsService.getGreetings() + " $name!"
    } catch (exception: Exception) {
        "on $name, we get an error: $exception"
    }
}