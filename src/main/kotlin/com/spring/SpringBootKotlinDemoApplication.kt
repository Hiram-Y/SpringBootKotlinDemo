package com.spring

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableAutoConfiguration
class SpringBootKotlinDemoApplication

fun main(args: Array<String>) {
    runApplication<SpringBootKotlinDemoApplication>(*args)
}
