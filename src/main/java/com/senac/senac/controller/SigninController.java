package com.senac.senac.controller;

import javax.management.RuntimeErrorException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senac.senac.utils.LoginData;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/signin")
public class SigninController {
    
    @PostMapping
    public ResponseEntity  validateLogin(HttpServletRequest request, HttpServletResponse response, @RequestBody LoginData loginData){
        System.out.println(loginData.getLogin());
        System.out.println(loginData.getPassword());

        //TO-DO
        //implementar lógica para login

        if(1 != 1){
            throw new RuntimeErrorException(null, "Dados de login inválidos");
        }

        return ResponseEntity.ok().build();
    }
}
