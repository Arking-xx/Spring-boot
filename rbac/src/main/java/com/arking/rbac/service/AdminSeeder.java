package com.arking.rbac.service;

import com.arking.rbac.model.ERole;
import com.arking.rbac.model.Employee;
import com.arking.rbac.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class AdminSeeder implements CommandLineRunner {
    private final EmployeeRepository repository;
    private final PasswordEncoder passwordEncoder;

    public AdminSeeder(EmployeeRepository employeeRepository, PasswordEncoder passwordEncoder) {
        this.repository = employeeRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Value("${ADMIN_USERNAME}")
    private String adminUsername;

    @Value("${ADMIN_PASSWORD}")
    private String adminPassword;

    @Override
    public void run(String... args) throws Exception {
        boolean adminExist = repository.existsByRole(ERole.ROLE_ADMIN);


        if(!adminExist){
            Employee admin = new Employee();
            admin.setUsername(adminUsername);
            admin.setPassword(passwordEncoder.encode(adminPassword));
            admin.setRole(ERole.ROLE_ADMIN);

            repository.save(admin);
        }
    }
}
