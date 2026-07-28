package com.arking.ems_server.employee;

import com.arking.ems_server.exception.EmployeeNotFound;
import org.springframework.stereotype.Service;
import com.arking.ems_server.employee.EmployeeMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImplementation implements EmployeeService{

    private EmployeeRepository employeeRepository;
    private EmployeeMapper employeeMapper;

    public EmployeeServiceImplementation(EmployeeRepository repo, EmployeeMapper employeeMapper) {
        this.employeeRepository = repo;
        this.employeeMapper = employeeMapper;
    }

    @Override
    public EmployeeDto registerEmployee(EmployeeDto createEmployeeDto){
        Employee employee = employeeMapper.toEntity(createEmployeeDto);
        Employee saveEmployee = employeeRepository.save(employee);

        return employeeMapper.toDTO(saveEmployee);
    }


    @Override
    public EmployeeDto getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(EmployeeNotFound::new);

        return employeeMapper.toDTO(employee);
    }


    @Override
    public List<EmployeeDto> getAllEmployeeDto(){
        List<Employee> employee = employeeRepository.findAll();
        return employee.stream().map(allEmployee -> employeeMapper.toDTO(allEmployee))
                .collect(Collectors.toList());
    }


    @Override
    public EmployeeDto updateEmployee(Long id,EmployeeDto updateEmployeeInfo){
        Employee employeeInfo = employeeRepository.findById(id).orElseThrow(EmployeeNotFound::new);

        employeeInfo.setFirstName(updateEmployeeInfo.getFirstName());
        employeeInfo.setLastName(updateEmployeeInfo.getLastName());
        employeeInfo.setEmail(updateEmployeeInfo.getEmail());
        employeeInfo.setJobTitle(employeeInfo.getJobTitle());


        Employee updateEmployeeObj = employeeRepository.save(employeeInfo);
        return employeeMapper.toDTO(updateEmployeeObj);
    }

    @Override
     public void deleteEmployee(Long id){
        Employee employeeId = employeeRepository.findById(id).orElseThrow(EmployeeNotFound::new);
        employeeRepository.delete(employeeId);
    }

}
