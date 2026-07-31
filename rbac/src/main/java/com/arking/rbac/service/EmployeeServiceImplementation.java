package com.arking.rbac.service;

import com.arking.rbac.dto.EmployeeResponseDto;
import com.arking.rbac.dto.JwtResponseDto;
import com.arking.rbac.dto.LoginDto;
import com.arking.rbac.dto.RegisterDto;
import com.arking.rbac.jwt.JwtUtils;
import com.arking.rbac.mapper.EmployeeResponseMapper;
import com.arking.rbac.mapper.RegisterMapper;
import com.arking.rbac.model.ERole;
import com.arking.rbac.model.Employee;
import com.arking.rbac.repository.EmployeeRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeServiceImplementation implements EmployeeService {

    private final EmployeeRepository empRepository;
    private final EmployeeResponseMapper empResponseMapper;
    private final RegisterMapper registerMapper;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;


    public EmployeeServiceImplementation(EmployeeRepository empRepository, EmployeeResponseMapper empResponseMapper, RegisterMapper registerMapper, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager, JwtUtils jwtUtils) {
        this.empRepository = empRepository;
        this.empResponseMapper = empResponseMapper;
        this.registerMapper = registerMapper;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtUtils = jwtUtils;
    }

    @Override
    public EmployeeResponseDto registerEmployee(RegisterDto registerDto) {
        Employee employee = registerMapper.toEntity(registerDto);
        employee.setPassword(passwordEncoder.encode(registerDto.getPassword()));
        employee.setRole(ERole.ROLE_EMPLOYEE);

        Employee saved = empRepository.save(employee);
        return empResponseMapper.toDto(saved);
    }

    @Override
    public JwtResponseDto login(LoginDto loginDto) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginDto.getUsername(),
                        loginDto.getPassword()
                )
        );
        Employee employee = empRepository.findByUsername(loginDto.getUsername())
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        Map<String, Object> claims = new HashMap<>();
         claims.put("role", employee.getRole().name());

        String accessToken = jwtUtils.generateAccessToken(claims, employee);
        String refreshToken = jwtUtils.generateRefreshToken(employee);

        return new JwtResponseDto(accessToken, refreshToken, employee.getUsername(),employee.getRole());

    }
}
