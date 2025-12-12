package com.challenge.api.service;

import com.challenge.api.model.Employee;
import com.challenge.api.repository.EmployeeRepository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees() {
        return List.copyOf(employeeRepository.findAll());
    }

    public Optional<Employee> getEmployeeByUuid(UUID uuid) {
        return employeeRepository.findByUuid(uuid);
    }

    public Employee createEmployee(Employee employeeData) {
        // Business logic:
        // 1. Create a concrete instance that implements the interface.
        // 2. Set the UUID to null before saving to force the Repository to generate a new one
        //    (assuming the client might send a UUID in the request body, which should be ignored for creation).
        employeeData.setUuid(null);
        return employeeRepository.save(employeeData);
    }
}
