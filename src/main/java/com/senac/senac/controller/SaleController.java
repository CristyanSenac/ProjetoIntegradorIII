package com.senac.senac.controller;
import java.math.BigDecimal;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senac.senac.dto.SaleDto;
import com.senac.senac.entity.Product;
import com.senac.senac.entity.Sale;
import com.senac.senac.entity.User;

@RestController
@RequestMapping("/sale")
public class SaleController {
    @GetMapping
    public ResponseEntity<List<SaleDto>> findAll(){
        List<SaleDto> saleDtos = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            Sale sale = new Sale();
            Product product = new Product();
            product.setName("Produto " + i );
            product.setPrice(BigDecimal.valueOf(i));
            User user = new User(Long.valueOf(i));

            sale.setDate(new Date());
            sale.setUser(user);
            sale.setProduct(product);
            sale.setId(Long.valueOf(i)); 

            saleDtos.add(new SaleDto(sale));           
        }

        return ResponseEntity.ok(saleDtos);
    }

    @PostMapping(value = "/{idProduct}")
    public ResponseEntity<Sale> createSale(@PathVariable String idProduct) throws URISyntaxException{
        //implementar logica para criar venda e salvar no banco
        Long id = Long.valueOf(idProduct);
        Sale sale = new Sale();
        sale.setId(1L);
        sale.setProduct(new Product("teste " + id, "teste descricao"));
        
        URI uri = new URI("http://localhost:8080/sale/" + sale.getId());
        return ResponseEntity.created(uri).body(sale);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSale(@PathVariable Long id){
        System.out.println("Deletar venda com id: " + id);
        return ResponseEntity.ok("Venda excluida com sucesso");
    }
}
