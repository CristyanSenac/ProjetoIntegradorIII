
package com.senac.senac.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name = "Product")
@Table(name = "product")
public class Product {

    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private String description;
    
    @ManyToOne
    @JoinColumn(name = "product_type_id")
    private ProductType type;
    @Column
    private BigDecimal price;
    @Column
    private Integer inventory;
    @Column
    private String urlImage;
    @Column
    private boolean removed;
    
    private String typeName;

    
    public void setTypeAndName(ProductType type){
        this.type = type;
        this.typeName = type.getType();
    }
}
