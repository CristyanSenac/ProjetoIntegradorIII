package com.senac.senac.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

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
import com.senac.senac.entity.ProductType;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/product")
public class ProductsController {
    
    @GetMapping
    public List<Product> getProducts(HttpServletRequest request, HttpServletResponse response, Model model){
        //TO-DO
        //implementar lógica para trazer somente produtos em estoque
        List<Product> products = new ArrayList<>();
        for (int i = 1; i <= 20; i++) {
            String nomeProduto = "Nome produto " + i;
            String descricaoProduto = "Descrição produto " + (i + 1);
        
            Product product = new Product(nomeProduto, descricaoProduto);
            product.setId(Long.valueOf(i));
            product.setPrice(BigDecimal.valueOf(i));
            product.setTypeAndName(new ProductType(1L, "NOME TIPO"));
            product.setInventory(1);
            products.add(product);
        }

        return products;
    }

    @PutMapping(value="/updateinventory/{productId}")
    public ResponseEntity<String> updateInventory(@PathVariable Long productId, @RequestParam String action, @RequestParam Integer actual){
        
        if (actual == 0 && action.equals("decrease")) 
            throw new RuntimeException("Não é possível diminuir o estoque de um produto com estoque zero.");
           
        
        return ResponseEntity.ok("Sucesso ao alterar o estoque"); 
    }

    @DeleteMapping("/delete/{productId}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long productId) {
        return ResponseEntity.ok("Produto excluído com sucesso. ID: " + productId);
    }

    
    @PostMapping
    public ResponseEntity<String> createProduct(@RequestBody ProductDto productDto) {
        // Lógica para criar o produto e salvar
        System.out.println(productDto);

        return ResponseEntity.ok("Produto criado com sucesso");
    }
}


