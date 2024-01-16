package com.senac.senac.dto;

import com.senac.senac.entity.User;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDto {
    private Long id;
    private String name;
    private String typeName;
    private Long typeId;

    public UserDto(User user){
        this.id = user.getId();
        this.name = user.getName();
        this.typeName = user.getUserType().getType();
        this.typeId = user.getUserType().getId();
    }
}
