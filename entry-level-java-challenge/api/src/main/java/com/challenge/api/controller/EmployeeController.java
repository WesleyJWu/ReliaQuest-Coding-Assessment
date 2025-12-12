package com.challenge.api.controller;

import com.challenge.api.model.Employee;
import com.challenge.api.model.EmployeeImpl;
import com.challenge.api.service.EmployeeService;
import java.util.List;
import java.util.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

/**
 * Fill in the missing aspects of this Spring Web REST Controller. Don't forget to add a Service layer.
 */
@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    /**
     * getAllEmployees()
     * @implNote Need not be concerned with an actual persistence layer. Generate mock Employee models as necessary.
     * @return One or more Employees.
     */
    @GetMapping // Maps to GET /api/v1/employee
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    /**
     * getEmployeeByUuid(...)
     * @implNote Need not be concerned with an actual persistence layer. Generate mock Employee model as necessary.
     * @param uuid Employee UUID (comes from the path)
     * @return Requested Employee if exists
     */
    @GetMapping("/{uuid}") // Maps to GET /api/v1/employee/{uuid}
    public Employee getEmployeeByUuid(@PathVariable UUID uuid) {
        // Use map/orElseThrow to return the Employee or throw a 404 NOT FOUND exception
        return employeeService
                .getEmployeeByUuid(uuid)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found with UUID: " + uuid));
    }

    /**
     * createEmployee(...)
     * @implNote Need not be concerned with an actual persistence layer.
     * @param requestBody The Employee data to be created.
     * @return Newly created Employee with its generated UUID.
     */
    @PostMapping // Maps to POST /api/v1/employee
    @ResponseStatus(HttpStatus.CREATED)
    public Employee createEmployee(@RequestBody EmployeeImpl requestBody) {
        // Deserialize the JSON into an EmployeeImpl object.
        return employeeService.createEmployee(requestBody);
    }
}
