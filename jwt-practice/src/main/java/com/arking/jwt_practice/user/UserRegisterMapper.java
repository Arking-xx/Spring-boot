package com.arking.jwt_practice.user;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserRegisterMapper {

    User toEntity(RegisterDTO registerDTO);

}
