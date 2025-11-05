package com.maji.maojianwei.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    // 定义一个可访问的接口：http://localhost:8888/hello
    @GetMapping("/hello")
    public String hello() {
        return "Hello, Spring Boot!";
    }
}