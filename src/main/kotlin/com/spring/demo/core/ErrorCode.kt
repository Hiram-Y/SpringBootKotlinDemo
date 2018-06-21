package com.spring.demo.core

enum class ErrorCode(val code: Int, val msg: String = "") {
    ERROR_OK(10000),
    ERROR_TOKEN(10001, "ERROR TOKEN"),
    ERROR_USER_PASSWORD(10002, "ERROR USER OR PASSWORD")
}
