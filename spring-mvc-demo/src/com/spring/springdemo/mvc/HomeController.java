package com.spring.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //----> Tells Spring that this is an MVC controller
public class HomeController {
    // Using controller to display Main Menu Page
    @RequestMapping("/")
    public String showPage(){
        return "main-menu";
    }
}
