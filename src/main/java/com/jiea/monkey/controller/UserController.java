package com.jiea.monkey.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
public class UserController {

    @RequestMapping("modifyPassword")
    public String modifyPassword(String oldPassword, String newPassword){
        return null;
    }
}
