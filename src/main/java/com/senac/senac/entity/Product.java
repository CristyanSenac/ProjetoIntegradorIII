
package com.senac.senac.entity;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
//Anotações JPA comentadas enquanto não há conexão com banco de dados
//@Entity(name = "Product")
//@Table(name = "product")
public class Product {

    //@Column
    //@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    
    //@ManyToOne
    //@JoinColumn(name = "product_type_id")
    private ProductType type;
    
    private BigDecimal price;
    private Integer inventory;
    private String urlImage;
    private String typeName;

    public Product(String name, String description){
        this.name = name;
        this.description = description;
    }
    
    public void setTypeAndName(ProductType type){
        this.type = type;
        this.typeName = type.getType();
    }
}
