package com.arking.ems_server.exception;

public class EmployeeNotFound extends RuntimeException {
    public EmployeeNotFound() {
        super("Employee ID not found.");
    }
}
