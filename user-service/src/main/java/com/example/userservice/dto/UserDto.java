package com.example.userservice.dto;

import com.example.userservice.entity.User;
import com.example.userservice.vo.ResponseOrder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
public class UserDto {
    private String email;
    private String name;
    private String pwd;
    private String userId;
    private LocalDateTime createdAt;
    private String encryptedPwd;

    private List<ResponseOrder> orders;


    public User toEntity() {
        User user = new User();
        user.setEmail(email);
        user.setName(name);
        user.setPwd(pwd);
        user.setUserId(userId);
        user.setEncryptedPwd(encryptedPwd);
        return user;
    }

    public static UserDto of(User user) {
        UserDto userDto = new UserDto();
        userDto.setEmail(user.getEmail());
        userDto.setName(user.getName());
        userDto.setPwd(user.getPwd());
        userDto.setUserId(user.getUserId());
        userDto.setCreatedAt(user.getCreatedAt());
        userDto.setEncryptedPwd(user.getEncryptedPwd());
        return userDto;
    }

    public static UserDto of(User user, List<ResponseOrder> orders) {
        UserDto userDto = of(user);
        userDto.setOrders(orders);
        return userDto;
    }
}
