package com.challenge.api.model;

import java.time.Instant;
import java.util.UUID;

public class EmployeeImpl implements Employee {

    private UUID uuid;
    private String firstName;
    private String lastName;
    private String jobTitle;
    private String email;
    private Integer salary;
    private Integer age;
    private Instant contractHireDate;
    private Instant contractTerminationDate;

    public EmployeeImpl() {
        this.uuid = UUID.randomUUID(); // Set a default UUID, overwritten if loaded from data store
        this.contractHireDate = Instant.now();
    }

    // --- Getters ---

    @Override
    public UUID getUuid() {
        return uuid;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public String getFullName() {
        return (firstName != null ? firstName : "") + (lastName != null ? " " + lastName : "");
    }

    @Override
    public Integer getSalary() {
        return salary;
    }

    @Override
    public Integer getAge() {
        return age;
    }

    @Override
    public String getJobTitle() {
        return jobTitle;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public Instant getContractHireDate() {
        return contractHireDate;
    }

    @Override
    public Instant getContractTerminationDate() {
        return contractTerminationDate;
    }

    // --- Setters ---

    @Override
    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    @Override
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public void setFullName(String name) {}

    @Override
    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    @Override
    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public void setContractHireDate(Instant date) {
        this.contractHireDate = date;
    }

    @Override
    public void setContractTerminationDate(Instant date) {
        this.contractTerminationDate = date;
    }
}
