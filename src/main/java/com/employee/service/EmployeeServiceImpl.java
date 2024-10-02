package com.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.employee.entity.Employee;
import com.employee.repository.employeeRepository;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;

/**
 * EmployeeServiceImpl implements the EmployeeService interface.
 * It provides the concrete implementation for employee-related operations,
 * including CRUD operations and session management.
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private employeeRepository employeeRepo;	 // Repository for accessing employee data
	
	
	/**
     * Saves a new Employee entity to the database.
     * @param emp The Employee entity to be saved.
     * @return The saved Employee entity.
     */
	@Override
	@Transactional
	public Employee saveEmployee(Employee emp) {
			Employee newEmp = employeeRepo.save(emp);	// Save the employee and return the saved entity
		return newEmp;
	}
	
	/**
     * Retrieves all Employee entities from the database.
     * @return A list of all Employee entities.
     */
	@Override
	public List<Employee> getAllEmp() {
		
		return employeeRepo.findAll(); // Fetch and return all employees
	}

	/**
     * Retrieves an Employee entity by its ID.
     * @param id The ID of the Employee to retrieve.
     * @return The Employee entity with the specified ID, or null if not found.
     */
	@Override
	public Employee getEmpById(int id) {
		
		return employeeRepo.findById(id).get();	// Return the employee or null if not found
	}

	
	/**
     * Deletes an Employee entity from the database by its ID.
     * @param id The ID of the Employee to be deleted.
     * @return true if the Employee was successfully deleted, false otherwise.
     */
	@Override
	@Transactional
	public boolean deleteEmp(int id) {
			Employee emp = employeeRepo.findById(id).get(); 	// Find the employee by ID
			if(emp !=null) {
				employeeRepo.delete(emp);	// Delete the employee if found
				return true;	
			}
		return false;		// Return false if the employee was not found
	}
	
	/**
     * Removes a session message attribute.
     * This is typically used to clear messages after they have been displayed to the user.
     */
	public void removeSessoinMessage() {
		HttpSession session = ((ServletRequestAttributes)((RequestContextHolder.getRequestAttributes()))).getRequest().getSession();
		
		session.removeAttribute("msg");	// Remove the "msg" attribute from the session
	}
	
}
