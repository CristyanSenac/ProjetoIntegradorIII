package com.senac.senac.views;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class MainView {
    
    @GetMapping
    public String getMainView(){
        System.out.println("teste");
        return "home";
    }
}
