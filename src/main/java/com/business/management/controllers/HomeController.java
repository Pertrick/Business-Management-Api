package com.business.management.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/home")
    public String home(){
        return "home";
    }

    @GetMapping("/")
    public String welcome(){
        return "welcome";
    }
}