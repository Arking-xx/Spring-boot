package com.arking.rbac.service;

import com.arking.rbac.dto.EmployeeResponseDto;
import com.arking.rbac.dto.JwtResponseDto;
import com.arking.rbac.dto.LoginDto;
import com.arking.rbac.dto.RegisterDto;

public interface EmployeeService {

    EmployeeResponseDto registerEmployee(RegisterDto registerDto);
    JwtResponseDto login(LoginDto loginDto);

}

