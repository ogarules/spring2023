package com.example.demo.ejercicio25.dao.mapper;

import com.example.demo.ejercicio25.domain.User;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserEntity {
    private Long userId;
    private Long fkCustomerId;
    private String userName;
    private String password;

    public static UserEntity map(User user){
        return UserEntity.builder()
                         .fkCustomerId(user.getCustomer().getId())
                         .password(user.getPassword())
                         .userId(user.getId())
                         .userName(user.getUserName())
                         .build();
    }
}
