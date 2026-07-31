package com.arking.rbac.dto;

import com.arking.rbac.model.ERole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.boot.internal.Abstract;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EmployeeResponseDto {

    private String username;
    private String firstName;
    private String lastName;
    private ERole role;


}
