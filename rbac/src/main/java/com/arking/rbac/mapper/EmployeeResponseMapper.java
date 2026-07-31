package com.arking.rbac.mapper;

import com.arking.rbac.dto.EmployeeResponseDto;
import com.arking.rbac.model.Employee;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmployeeResponseMapper {

 EmployeeResponseDto toDto(Employee employee);

}
