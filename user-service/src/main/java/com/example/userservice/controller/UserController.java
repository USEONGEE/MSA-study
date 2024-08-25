package com.example.userservice.controller;

import com.example.userservice.dto.UserDto;
import com.example.userservice.entity.User;
import com.example.userservice.service.UserService;
import com.example.userservice.vo.RequestUser;
import com.example.userservice.vo.ResponseUser;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user-service")
@RequiredArgsConstructor
public class UserController {

    private final Environment env;
    private final UserService userService;

    @Value("${greeting.message}")
    private String greetingMessage;

    @GetMapping("/health_check")
    public String healthCheck() {
        return String.format("User Service is up and running on PORT %s", env.getProperty("local.server.port"));
    }

    @GetMapping("/welcome")
    public String welcome() {
        return greetingMessage;
    }

    @PostMapping("/users")
    public ResponseEntity createUser(@RequestBody @Validated RequestUser requestUser) {
        UserDto user = userService.createUser(requestUser.toDto());
        return new ResponseEntity(ResponseUser.of(user), HttpStatus.CREATED);
    }

    @GetMapping("/users")
    public ResponseEntity getUsers() {
        Iterable<User> userByAll = userService.getUserByAll();
        List<ResponseUser> result = new ArrayList<>();
        for (User user : userByAll) {
            result.add(ResponseUser.of(UserDto.of(user)));
        }

        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<ResponseUser> getUser(@PathVariable("userId") String userId) {
        UserDto userByUserId = userService.getUserByUserId(userId);
        return ResponseEntity.status(HttpStatus.OK).body(ResponseUser.of(userByUserId));
    }
}
