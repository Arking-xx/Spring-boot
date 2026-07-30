package com.arking.jwt_practice.user;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserResponseMapper {

 UserResponseDTO toDTO(User user);

}
