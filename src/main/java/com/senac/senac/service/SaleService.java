package com.senac.senac.service;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senac.senac.dto.SaleDto;
import com.senac.senac.entity.Product;
import com.senac.senac.entity.Sale;
import com.senac.senac.entity.User;
import com.senac.senac.repository.SaleRepository;

@Service
public class SaleService {
    @Autowired
    private SaleRepository repository;
    @Autowired
    private ProductService productService;
    @Autowired
    private UserService userService;

    public List<SaleDto> findAll(){
        List<Sale> list = repository.findByRemoved(false);
        List<SaleDto> dtos = list.stream().map(SaleDto::new).toList();
        return dtos;
    }
    public List<SaleDto> findAllByUserId(Long userId){
        List<Sale> list = repository.findByRemovedAndUserId(false, userId);
        List<SaleDto> dtos = list.stream().map(SaleDto::new).toList();
        return dtos;
    }
    public Sale createSale(Long idProduct, Long idUser) {
        Product product = productService.findOne(idProduct);
        User user = userService.findOne(idUser);

        if (product == null || user == null)
            throw new RuntimeException("Erro ao criar venda");
        
        Sale sale = new Sale(null, user, new Date(), product, false);

        return repository.save(sale);
    }
    public void deleteSale(Long id) {
        Sale sale = repository.findById(id).orElseThrow(() -> new RuntimeException("Venda não encontrada"));
        sale.setRemoved(true);
        repository.save(sale);
    }


}
