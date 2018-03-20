package com.jiea.monkey.controller;

import com.jiea.monkey.domain.User;
import com.jiea.monkey.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class HelloWorldController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "hello", method = RequestMethod.GET)
    public String hello(){
        return "Hello World";
    }

    @GetMapping("user")
    public int user(){
        User user = new User();
        user.setUsername("111");
        return userService.addUser(user);
    }
}
