
package com.senac.senac.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
//Anotações JPA comentadas enquanto não há conexão com banco de dados
//@Entity(name = "User")
//@Table(name = "user")
public class User {

    //@Column
    //@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

}
