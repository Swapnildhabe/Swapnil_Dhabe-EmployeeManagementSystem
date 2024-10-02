package com.employee.service;

import java.util.List;

import com.employee.entity.Employee;


/**
 * EmployeeService defines the contract for employee-related operations.
 * It provides methods for creating, retrieving, updating, and deleting Employee entities.
 */
public interface EmployeeService {
	
	  /**
     * Saves a new Employee entity to the database.
     * @param emp The Employee entity to be saved.
     * @return The saved Employee entity.
     */
	public Employee saveEmployee(Employee emp);
	
	 /**
     * Retrieves all Employee entities from the database.
     * @return A list of all Employee entities.
     */
	public List<Employee> getAllEmp();
	
	 /**
     * Retrieves an Employee entity by its ID.
     * @param id The ID of the Employee to retrieve.
     * @return The Employee entity with the specified ID, or null if not found.
     */
	public Employee getEmpById(int id);
	
    /**
     * Deletes an Employee entity from the database by its ID.
     * @param id The ID of the Employee to be deleted.
     * @return true if the Employee was successfully deleted, false otherwise.
     */
	public boolean deleteEmp(int id);
	
}
