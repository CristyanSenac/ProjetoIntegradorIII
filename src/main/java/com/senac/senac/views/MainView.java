package com.senac.senac.views;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.senac.senac.service.UserService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/home")
public class MainView {
    @Autowired
    UserService userService;
    @GetMapping
    public String getMainView(HttpServletRequest request, Model model){
        if(userService.validateUserAuthenticated(request, model) == null)
            return "login";

        return "home";
    }
}
