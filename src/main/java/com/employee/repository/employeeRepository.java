package com.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee.entity.Employee;

/**
 * EmployeeRepository provides an interface for CRUD operations on Employee entities.
 * It extends JpaRepository, providing methods for interacting with the database.
 */
public interface employeeRepository extends JpaRepository<Employee, Integer> {
    // Additional custom query methods can be defined here if needed
}
