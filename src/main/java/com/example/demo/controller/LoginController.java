package com.example.demo.controller;

import com.example.demo.model.LoginRequest;
import com.example.demo.model.LoginResponse;
import com.example.demo.service.LoginServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/auth")
public class LoginController {

    @Autowired
    private LoginServiceImpl loginService;

    // Build Login REST API

    //@PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest){
        String token = loginService.login(loginRequest);

        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setAccessToken(token);

        return new ResponseEntity<>(loginResponse, HttpStatus.OK);
    }

}
