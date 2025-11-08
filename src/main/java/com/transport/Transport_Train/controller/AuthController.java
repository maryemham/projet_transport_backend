package com.transport.Transport_Train.controller;

import com.transport.Transport_Train.dto.RegisterRequest;
import com.transport.Transport_Train.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*") // Optionnel, mais sûr
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public String register(@RequestBody RegisterRequest request) {
        return authService.register(
                request.getEmail(),
                request.getMotDePasse(),
                request.getNom(),
                request.getPrenom()
        );
    }

    @GetMapping("/verify")
    public String verifyAccount(@RequestParam String token) {
        return authService.verifyAccount(token);
    }
}