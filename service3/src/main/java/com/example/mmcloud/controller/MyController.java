package com.example.mmcloud.controller;

import com.example.mmcloud.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    @Autowired
    MyService myService;

    @GetMapping("/getsayy")
    public String getSay() {
        return myService.say();
    }
}
