package com.senac.senac.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.senac.senac.dto.ProductDto;
import com.senac.senac.entity.Product;
import com.senac.senac.service.ProductService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/product")
public class ProductsController {
    @Autowired
    private ProductService service;

    @GetMapping
    public List<Product> getProducts(HttpServletRequest request, HttpServletResponse response, Model model){
        return service.getProducts();
    }

    @PutMapping(value="/updateinventory/{productId}")
    public ResponseEntity<Product> updateInventory(@PathVariable Long productId, @RequestParam String action){
        
        return ResponseEntity.ok(service.updateInventory(productId, action)); 
    }

    @DeleteMapping("/delete/{productId}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long productId) {
        service.removeProduct(productId);
        return ResponseEntity.ok("Produto excluído com sucesso. ID: " + productId);
    }

    
    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody ProductDto productDto) {
        return ResponseEntity.ok(service.createProduct(productDto));
    }
}


