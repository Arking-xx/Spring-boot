package com.arking.rbac.repository;

import com.arking.rbac.model.ERole;
import com.arking.rbac.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Optional<Employee>findByUsername(String username);
    boolean existsByRole(ERole eRole);
    boolean existsByUsername(String username);
}
