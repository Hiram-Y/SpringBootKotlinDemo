package com.spring.demo.core

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity


class JsonResult @JvmOverloads constructor(val data: Any? = null) {
    var code: Int? = null
        private set
    var msg: String? = null
        private set

    private fun createRespone(rsp : JsonResult) = ResponseEntity(rsp, HttpStatus.OK)

    fun send(err: ErrorCode): ResponseEntity<JsonResult> {
        this.code = err.code
        this.msg = err.msg
        return createRespone(this)
    }
    fun send(code: Int, msg: String?) : ResponseEntity<JsonResult> {
        this.code = code
        this.msg = msg
        return createRespone(this)
    }
    fun ok() = send(ErrorCode.ERROR_OK)
}
