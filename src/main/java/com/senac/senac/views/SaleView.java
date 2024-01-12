package com.senac.senac.views;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.senac.senac.controller.SaleController;
import com.senac.senac.dto.SaleDto;
import com.senac.senac.entity.Sale;

@Controller
@RequestMapping("/sales")
public class SaleView {
    @Autowired
    private SaleController saleController;
    
    @GetMapping
    public String getSalesView(Model model){
        List<SaleDto> sales = saleController.findAll().getBody();
        BigDecimal total = sales.stream().map(p -> p.getPrice()).reduce(BigDecimal.ZERO, BigDecimal::add);
        String totalValue = total.toString().replace(".", ",");
        totalValue = totalValue.contains(",") ? totalValue + "00" : totalValue + ",00";
        model.addAttribute("sales", sales);
        model.addAttribute("total", totalValue);
        return "sales";
    }

    @GetMapping("/mySales")
    public String getMySalesView(Model model){
        List<SaleDto> sales = saleController.findAll().getBody();
        model.addAttribute("sales", sales);
        return "my-sales";
    }
}
