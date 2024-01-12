package com.senac.senac.views;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.senac.senac.controller.ProductsController;
import com.senac.senac.entity.Product;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@Controller
@RequestMapping("/products")
public class ProductView {
    @Autowired
    ProductsController controllerRest;
    @GetMapping
    public String getMainView(HttpServletRequest request, HttpServletResponse response, Model model) {
        List<Product> productList = controllerRest.getProducts(request, response, model);
        model.addAttribute("productList", productList);
        return "products";
    }

    @GetMapping("/manage")
    public String getProductManagementView(HttpServletRequest request, HttpServletResponse response, Model model){
        List<Product> productList = controllerRest.getProducts(request, response, model);
        model.addAttribute("productList", productList);
        return "manage-products";
    }
}
