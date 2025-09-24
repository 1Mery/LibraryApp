package com.example.libraryNew.controller;

import com.example.libraryNew.dto.request.auth.LoginRequest;
import com.example.libraryNew.dto.request.auth.RegisterRequest;
import com.example.libraryNew.dto.response.auth.LoginResponse;
import com.example.libraryNew.dto.response.auth.RegisteredResponse;
import com.example.libraryNew.service.AuthService;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/auth")
@RestController
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("register")
    public RegisteredResponse register(@RequestBody RegisterRequest request) {
        return authService.register(request);
    }

    @PostMapping("login")
    public LoginResponse login(@RequestBody LoginRequest request) {
        return authService.login(request);
    }

    @GetMapping("verify-token")
    public Boolean verifyToken(@RequestParam("token") String token) {
        return authService.validateToken(token);
    }
}
