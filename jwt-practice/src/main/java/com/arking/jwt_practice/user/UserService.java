package com.arking.jwt_practice.user;

import com.arking.jwt_practice.jwt.JwtResponse;

public interface UserService {

    UserResponseDTO registerUser(RegisterDTO registerDTO);
    JwtResponse login(LoginRequest loginRequest);

}
