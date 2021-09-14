package com.demo.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class TestController {
    public static void main(String[] args) {
        System.out.println("hahaahah");
        System.out.println("master");
    }
    @GetMapping("hello")
    public String hello(){
        return "hello我";
    }
}
