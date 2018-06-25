package com.spring.demo.controller


import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/ftl")
class FreemarkerController{

    @RequestMapping("/test")
    fun test(model:Model):String{
        model.addAttribute("name","freemarker")
        return "freemarker/index"
    }
}