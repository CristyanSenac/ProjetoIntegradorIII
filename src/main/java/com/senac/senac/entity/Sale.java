
package com.senac.senac.entity;


import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
//Anotações JPA comentadas enquanto não há conexão com banco de dados
//@Entity(name = "Sale")
//@Table(name = "sale")
public class Sale {

    //@Column
    //@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    //@ManyToOne
    //@JoinColumn(name = "user_id")
    private User user;
    private Date date;

    //@ManyToOne
    //@JoinColumn(name = "product_id")
    private Product product;

    
}
