package com.spring.demo.controller

import com.spring.demo.core.ApiException
import com.spring.demo.core.ErrorCode
import com.spring.demo.core.JsonResult
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController


@RestController
class DemoController{


    @RequestMapping("/hello")
    fun hello(@RequestParam(value = "name",defaultValue = "World")name:String): ResponseEntity<JsonResult> {
        if(name != "abc") throw ApiException(ErrorCode.ERROR_USER_PASSWORD)
        return JsonResult("hello $name").ok()
    }
}