package com.arking.learning_app;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SimpleController {

    @Value("${spring.application.name}")
    String appName;

    @RequestMapping("/")
    public String homePage(Model model){
        System.out.println("hite homepage");
        model.addAttribute("appName", appName);
        return "home";
    }
}
