package com.spring.demo

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class CustomersController{

    @Autowired
    val customersRepository: CustomersRepository? = null

    @RequestMapping("/queryAll")
    fun queryAll():List<Customers>{
        return customersRepository?.findAll().orEmpty()
    }
    @RequestMapping("/addCustomer")
    fun addCustomer(name:String,address:String,city:String,age:Int,love:String):String{

        val customer = Customers()
        customer.name = name
        customer.address = address
        customer.city = city
        customer.age = age
        customer.love = love

        customersRepository!!.save(customer)
        return "插入成功"
    }
    @RequestMapping("/test")
    fun test():String{

        return "插入成功"
    }
}