package com.arking.rbac.mapper;

import com.arking.rbac.dto.RegisterDto;
import com.arking.rbac.model.Employee;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RegisterMapper {

    Employee toEntity(RegisterDto registerDto);

}
