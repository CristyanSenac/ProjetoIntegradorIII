package com.senac.senac.views;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.senac.senac.controller.SaleController;
import com.senac.senac.dto.SaleDto;
import com.senac.senac.dto.UserDto;
import com.senac.senac.service.UserService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/sales")
public class SaleView {
    @Autowired
    private SaleController saleController;
    @Autowired
    UserService userService;
    
    @GetMapping
    public String getSalesView(HttpServletRequest request, Model model){
        UserDto user = userService.validateUserAuthenticated(request, model);
        if(user == null || !user.getTypeId().equals(1L))
            return "login";
        List<SaleDto> sales = saleController.findAll().getBody();
        BigDecimal total = sales.stream().map(p -> p.getPrice()).reduce(BigDecimal.ZERO, BigDecimal::add).setScale(2, RoundingMode.HALF_UP);
        String totalValue = total.toString().replace(".", ",");
        totalValue = totalValue.contains(",") ? totalValue + "00" : totalValue + ",00";
        model.addAttribute("sales", sales);
        model.addAttribute("total", totalValue);
        return "sales";
    }

    @GetMapping("/mySales")
    public String getMySalesView(HttpServletRequest request, Model model){
        UserDto user = userService.validateUserAuthenticated(request, model);
        if(user == null || !user.getTypeId().equals(2L))
            return "login";
        List<SaleDto> sales = saleController.findByUserId(user.getId()).getBody();
        model.addAttribute("sales", sales);
        return "my-sales";
    }
}
