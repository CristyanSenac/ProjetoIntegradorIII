package com.senac.senac.views;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginView {
    
    @GetMapping
    public String getLoginView(){
        return "login";
    }
}
