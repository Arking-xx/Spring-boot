package com.arking.jwt_practice.auth;

import com.arking.jwt_practice.jwt.JwtResponse;
import com.arking.jwt_practice.user.LoginRequest;
import com.arking.jwt_practice.user.RegisterDTO;
import com.arking.jwt_practice.user.UserResponseDTO;
import com.arking.jwt_practice.user.UserServiceImplem;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserServiceImplem userService;

    public AuthController(UserServiceImplem userService) {
        this.userService = userService;
    }


    @PostMapping("/register")
    public UserResponseDTO register(@RequestBody RegisterDTO register){
        return userService.registerUser(register);
    }

    @PostMapping("/login")
    public JwtResponse login(@RequestBody LoginRequest loginRequest){
        return userService.login(loginRequest);
    }

}
