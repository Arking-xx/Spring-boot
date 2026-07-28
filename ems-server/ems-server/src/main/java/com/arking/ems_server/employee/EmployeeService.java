package com.arking.ems_server.employee;

import java.util.List;

public interface EmployeeService {

    EmployeeDto registerEmployee(EmployeeDto employeeDto);

    EmployeeDto getEmployeeById(Long id);

    List<EmployeeDto> getAllEmployeeDto();

    EmployeeDto updateEmployee(Long id, EmployeeDto updateEmployee);

    void deleteEmployee(Long employeeId);

}
