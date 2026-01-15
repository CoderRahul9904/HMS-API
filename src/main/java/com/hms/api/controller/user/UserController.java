package com.hms.api.controller.user;


import com.hms.api.dto.user.CreateUserDto;
import com.hms.api.dto.user.UserResponseDto;
import com.hms.api.services.user.Impl.UserService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("/create/user")
    public UserResponseDto registerUser(@RequestBody CreateUserDto createUserDto) {
        return userService.createUser(createUserDto);
    }


}
