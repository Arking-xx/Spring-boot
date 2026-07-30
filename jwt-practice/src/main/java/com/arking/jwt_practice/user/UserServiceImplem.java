package com.arking.jwt_practice.user;

import com.arking.jwt_practice.jwt.JwtResponse;
import com.arking.jwt_practice.jwt.JwtUtils;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImplem implements UserService {

    private UserRepository userRepository;
    private UserRegisterMapper registerMapper;
    private UserResponseMapper responseMapper;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;

    public UserServiceImplem(UserRegisterMapper registerMapper,
                             UserRepository userRepository,
                             UserResponseMapper responseMapper,
                             PasswordEncoder passwordEncoder,
                             AuthenticationManager authenticationManager, JwtUtils jwtUtils){
        this.userRepository = userRepository;
        this.registerMapper = registerMapper;
        this.responseMapper = responseMapper;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtUtils = jwtUtils;
    }


    @Override
    public UserResponseDTO registerUser(RegisterDTO registerDTO) {
        User user = registerMapper.toEntity(registerDTO);
        user.setPassword(passwordEncoder.encode(registerDTO.getPassword()));
        User savedUser = userRepository.save(user);
        return responseMapper.toDTO(savedUser);
    }

    @Override
    public JwtResponse login(LoginRequest loginRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );
        String token = jwtUtils.generateToken(loginRequest.getUsername());

        return new JwtResponse(token, loginRequest.getUsername());

    }
}
