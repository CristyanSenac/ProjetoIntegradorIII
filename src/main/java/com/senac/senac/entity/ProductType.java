package com.senac.senac.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
//@Entity(name = "ProductType")
//@Table(name = "product_type")
public class ProductType {

    private Long id;
    private String type;
}
