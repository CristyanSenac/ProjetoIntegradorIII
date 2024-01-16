package com.senac.senac.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senac.senac.dto.UserDto;
import org.springframework.ui.Model;

import com.senac.senac.entity.Product;
import com.senac.senac.entity.User;
import com.senac.senac.repository.UserRepository;

import jakarta.servlet.http.HttpServletRequest;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserDto validateCredentials(String userName, String password){
        User user = userRepository.findByLoginAndPassword(userName, password);
        UserDto dto = new UserDto(user);

        return dto;
    }

    public UserDto validateUserAuthenticated(HttpServletRequest request, Model model){
        UserDto user = (UserDto) request.getSession().getAttribute("user");
        if(user != null)
            model.addAttribute("user", user);
        return user;
    }

    public User findOne(Long id){
        return userRepository.findById(id).orElse(null);
    }
}
