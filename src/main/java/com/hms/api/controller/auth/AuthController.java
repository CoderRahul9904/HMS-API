package com.hms.api.controller.auth;

import com.hms.api.services.auth.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final JwtService jwtService;

//    @PostMapping("/register")
//    public UserResponseDto register(@RequestBody CreateUserDto createUserDto) {
//
//    }
}
