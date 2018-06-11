package com.spring.demo

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class DemoController{

    @RequestMapping("/hello")
    fun hello(@RequestParam(value = "name",defaultValue = "World")name:String):String{

        return "Hello $name"
    }
}