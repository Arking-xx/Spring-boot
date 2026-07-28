package com.arking.ems_server.employee;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {

    private String firstName;
    private String lastName;
    private String gender;
    private String jobTitle;
    private String email;

}
