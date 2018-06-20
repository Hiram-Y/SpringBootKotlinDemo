package com.spring.demo.controller

import com.spring.demo.Customers
import com.spring.demo.CustomersRepository
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class CustomersController{

//    private val logger = LoggerFactory.getLogger(CustomersController::class.java)

    @Autowired //@Autowired 使用该注解可自动找到之前Spring自动创建的名为userRepository的Bean来填充数据
    val customersRepository: CustomersRepository? = null

    // 注意:
    // @GetMapping只匹配Get请求，是@RequestMapping(method=GET)的简写。
    // 同理还有@PostMapping等。
    // 如果只写@RequestMapping不指明请求方式表示匹配所有类型的请求。
    @GetMapping("/queryAll")
    fun queryAll():List<Customers>{
        val all = customersRepository?.findAll()
//        logger.info("查询结果：${all.toString()}")
        return all!!
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