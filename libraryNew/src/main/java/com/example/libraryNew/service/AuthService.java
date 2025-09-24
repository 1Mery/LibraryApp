package com.example.libraryNew.service;

import com.example.libraryNew.core.exception.type.BusinessException;
import com.example.libraryNew.core.jwt.JwtUtil;
import com.example.libraryNew.dto.request.auth.LoginRequest;
import com.example.libraryNew.dto.request.auth.RegisterRequest;
import com.example.libraryNew.dto.response.auth.LoginResponse;
import com.example.libraryNew.dto.response.auth.RegisteredResponse;
import com.example.libraryNew.entity.User;
import com.example.libraryNew.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthService {
    private final UserRepository  userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    public RegisteredResponse register(RegisterRequest request)
    {
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword())); // ASLA plain-text olarak yazmıyoruz.

        userRepository.save(user);

        RegisteredResponse response = new RegisteredResponse();
        response.setUsername(user.getUsername());
        return response;
    }

    public LoginResponse login(LoginRequest request)
    {
        User user = userRepository
                .findByUsername(request.getUsername())
                .orElseThrow(() -> new BusinessException("Wrong username or password."));

        if(!passwordEncoder.matches(request.getPassword(), user.getPassword()))
            throw new BusinessException("Wrong username or password.");

        List<String> roles = user
                .getOperationClaims()
                .stream()
                .map(o->o.getName())
                .toList();

        LoginResponse response = new LoginResponse();
        response.setToken(jwtUtil.generateToken(user.getUsername(), roles));
        return response;
    }

    public Boolean validateToken(String token)
    {
        return jwtUtil.validateToken(token);
    }
}
