package com.arking.rbac.controller;

import com.arking.rbac.dto.EmployeeResponseDto;
import com.arking.rbac.dto.JwtResponseDto;
import com.arking.rbac.dto.LoginDto;
import com.arking.rbac.dto.RegisterDto;
import com.arking.rbac.service.EmployeeServiceImplementation;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final EmployeeServiceImplementation empService;

    public AuthController(EmployeeServiceImplementation empService) {
        this.empService = empService;
    }


    @PostMapping("/register")
    public EmployeeResponseDto registerEmployee(@RequestBody RegisterDto register){
        return empService.registerEmployee(register);
    }

    @PostMapping("/login")
    public JwtResponseDto login(@RequestBody LoginDto login){
        return empService.login(login);
    }

}
