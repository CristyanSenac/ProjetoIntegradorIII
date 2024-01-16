package com.senac.senac.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senac.senac.dto.ProductDto;
import com.senac.senac.entity.Product;
import com.senac.senac.entity.ProductType;
import com.senac.senac.enums.ProductTypeEnum;
import com.senac.senac.repository.ProductRepository;
import com.senac.senac.repository.ProductTypeRepository;


@Service
public class ProductService {

    @Autowired
    ProductRepository repository;
    @Autowired
    ProductTypeRepository productTypeRepository;

    public List<Product> getProducts(){
        return repository.findProductsInInventory();
    }

    public Product findOne(Long id){
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Produto não encontrado!"));
    }

    public Product updateInventory(Long productId, String action) {
 
        Product product = repository.findById(productId).orElseThrow(() -> new RuntimeException("Produto não encontrado!"));

        if (product.getInventory() == 0 && action.equals("decrease")) 
            throw new RuntimeException("Não é possível diminuir o estoque de um produto com estoque zero.");

        if(action.equals("decrease"))
            product.setInventory(product.getInventory() - 1);
        else if(action.equals("increase"))
            product.setInventory(product.getInventory() + 1);
        else
            throw new RuntimeException("Ação não encontrada");

        return repository.save(product);
    }

    public void removeProduct(Long productId) {
        Product product = findOne(productId);
        product.setInventory(0);
        product.setRemoved(true);
        repository.save(product);
    }

    public Product createProduct(ProductDto dto) {
        Product product = new Product();
        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        try{
            product.setPrice(new BigDecimal(dto.getPrice()));
        }catch(Exception e) {
            throw new RuntimeException("Valor inválido");
        }
        product.setInventory(dto.getInventory());
        product.setRemoved(false);
        product.setTypeAndName(productTypeRepository.findById(dto.getTypeId()).orElseThrow(() -> new RuntimeException("Tipo inválido")));
        return repository.save(product);
    }

}
