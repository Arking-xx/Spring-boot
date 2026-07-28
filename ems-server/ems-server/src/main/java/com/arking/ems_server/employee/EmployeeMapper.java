package com.arking.ems_server.employee;


import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    EmployeeDto toDTO(Employee employee);
    Employee toEntity(EmployeeDto employeeDto);

}
