package com.arking.rbac.dto;

import com.arking.rbac.model.ERole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class JwtResponseDto {

    private String accessToken;
    private String refreshToken;
    private String username;
    private ERole role;

    }
