package com.example.userservice.vo;

import com.example.userservice.dto.UserDto;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseUser {
    private String email;
    private String name;
    private String userId;

    private List<ResponseOrder> orders;

    public static ResponseUser of(UserDto userDto) {
        ResponseUser responseUser = new ResponseUser();
        responseUser.setEmail(userDto.getEmail());
        responseUser.setName(userDto.getName());
        responseUser.setUserId(userDto.getUserId());
        responseUser.setOrders(userDto.getOrders());
        return responseUser;
    }
}
