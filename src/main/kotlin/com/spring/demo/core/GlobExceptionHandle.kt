package com.spring.demo.core

import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MissingServletRequestParameterException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.servlet.NoHandlerFoundException

//自定义api异常返回
class ApiException(val code: ErrorCode, val data: Any? = null) : Exception(code.msg)

/**
 * 统一异常处理
 * </br>ControllerAdvice来做controller内部的全局异常处理，但对于未进入controller前的异常，该处理方法是无法进行捕获处理的，SpringBoot提供了ErrorController的处理类来处理所有的异常(TODO)。
 * </br>1.当普通调用时，跳转到自定义的错误页面；2.当ajax调用时，可返回约定的json数据对象，方便页面统一处理。
 */
@ControllerAdvice
class GlobExceptionHandle  {

    private val LOG = LoggerFactory.getLogger(LogAspect::class.java)

    @ExceptionHandler(ApiException::class)
    fun handleControllerException( ex: ApiException) = JsonResult(ex.data).send(ex.code)

    @ExceptionHandler(NoHandlerFoundException::class)
    fun handleNotFoundException(e: NoHandlerFoundException) : ResponseEntity<JsonResult> {
        LOG.info("handleNotFoundException----------------")
        val status = HttpStatus.NOT_FOUND

        return JsonResult().send(status.value(), e.message)
    }
    @ExceptionHandler(MissingServletRequestParameterException::class)
    fun handleMissingServletRequestParameterException(e: MissingServletRequestParameterException) : ResponseEntity<JsonResult> {
        val status = HttpStatus.BAD_REQUEST
        LOG.info("handleMissingServletRequestParameterException-------------------")
        return JsonResult().send(status.value(), e.message)
    }
}