package com.arking.ems_server.employee;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
@AllArgsConstructor
public class EmployeeController {

    EmployeeServiceImplementation employeeService;

    @PostMapping()
    public ResponseEntity<EmployeeDto> registerEmployee(@RequestBody EmployeeDto employeeDto){
        EmployeeDto register = employeeService.registerEmployee(employeeDto);
        return new ResponseEntity<>(register, HttpStatus.CREATED);
    }


    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long employeeId){
        EmployeeDto findEmployee = employeeService.getEmployeeById(employeeId);
        return ResponseEntity.ok(findEmployee);
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployee(){
       List<EmployeeDto> getAllEmployee = employeeService.getAllEmployeeDto();
       return ResponseEntity.ok(getAllEmployee);
    }


    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") Long id, @RequestBody EmployeeDto employeeInfo){
        EmployeeDto employee = employeeService.updateEmployee(id, employeeInfo);
        return ResponseEntity.ok(employee);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long id){
        employeeService.deleteEmployee(id);
        return ResponseEntity.ok("Employee Sucessfuly deleted");
    }


}
