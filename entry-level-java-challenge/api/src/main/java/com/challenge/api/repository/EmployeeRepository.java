package com.challenge.api.repository;

import com.challenge.api.model.Employee;
import com.challenge.api.model.EmployeeImpl;
import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeRepository {

    private final Map<UUID, Employee> employeeStore = new ConcurrentHashMap<>();

    // Initialize with mock data
    public EmployeeRepository() {
        // Use EmployeeImpl to create mock data
        EmployeeImpl alice = new EmployeeImpl();
        alice.setUuid(UUID.fromString("11111111-1111-1111-1111-111111111111"));
        alice.setFirstName("Alice");
        alice.setLastName("Smith");
        alice.setJobTitle("Lead Developer");
        alice.setEmail("alice@company.com");
        save(alice);

        EmployeeImpl bob = new EmployeeImpl();
        bob.setUuid(UUID.fromString("22222222-2222-2222-2222-222222222222"));
        bob.setFirstName("Bob");
        bob.setLastName("Johnson");
        bob.setJobTitle("QA Engineer");
        bob.setEmail("bob@company.com");
        save(bob);
    }

    public Collection<Employee> findAll() {
        return employeeStore.values();
    }

    public Optional<Employee> findByUuid(UUID uuid) {
        return Optional.ofNullable(employeeStore.get(uuid));
    }

    // Saves or updates an employee
    public Employee save(Employee employee) {
        // This mock layer ensures the UUID is set before storing it
        if (employee.getUuid() == null) {
            employee.setUuid(UUID.randomUUID());
        }
        employeeStore.put(employee.getUuid(), employee);
        return employee;
    }
}
