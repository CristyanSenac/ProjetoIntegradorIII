package com.senac.senac.controller;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senac.senac.dto.UserDto;
import com.senac.senac.service.UserService;
import com.senac.senac.utils.LoginData;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/signin")
public class SigninController {
    
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity  validateLogin(HttpServletRequest request, HttpServletResponse response, @RequestBody LoginData loginData){

        UserDto user = userService.validateCredentials(loginData.getLogin(), loginData.getPassword());
        
        if(user == null ){
            throw new RuntimeErrorException(null, "Dados de login inválidos");
        }
        
        HttpSession session = request.getSession();
        session.setAttribute("user", user);

        return ResponseEntity.ok().build();
    }
}
