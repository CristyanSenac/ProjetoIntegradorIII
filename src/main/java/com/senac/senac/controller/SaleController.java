package com.senac.senac.controller;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senac.senac.dto.SaleDto;
import com.senac.senac.entity.Sale;
import com.senac.senac.service.ProductService;
import com.senac.senac.service.SaleService;

@RestController
@RequestMapping("/sale")
public class SaleController {
    @Autowired
    private SaleService service;
    @Autowired
    private ProductService productService;
    @GetMapping
    public ResponseEntity<List<SaleDto>> findAll(){
        List<SaleDto> saleDtos = service.findAll();
        

        return ResponseEntity.ok(saleDtos);
    }

    @PostMapping(value = "/{idProduct}/user/{idUser}")
    public ResponseEntity<Sale> createSale(@PathVariable Long idProduct, @PathVariable Long idUser) throws URISyntaxException{
        Sale sale = service.createSale(idProduct, idUser);
        productService.updateInventory(idProduct, "decrease");
        URI uri = new URI("http://localhost:8080/sale/" + sale.getId());
        return ResponseEntity.created(uri).body(sale);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSale(@PathVariable Long id){
        service.deleteSale(id);
        return ResponseEntity.ok("Venda excluida com sucesso");
    }

    public ResponseEntity<List<SaleDto>> findByUserId(Long id) {
        return ResponseEntity.ok(service.findAllByUserId(id));
    }
}
