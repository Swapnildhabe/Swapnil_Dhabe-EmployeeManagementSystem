package com.employee.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.employee.entity.Employee;
import com.employee.service.EmployeeService;
import com.employee.service.EmployeeServiceImpl;

import jakarta.security.auth.message.callback.PrivateKeyCallback.Request;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

/**
 * HomeController handles the main navigation and employee-related functionalities,
 * including viewing, adding, editing, and deleting employees.
 */
@Controller
public class HomeController {
	@Autowired
	private EmployeeService employeeService;  // Service for handling employee operations
	
	/**
     * Displays the home page with a list of all employees.
     * @param m Model to hold the employee list
     * @return the name of the home view (index)
     */
	@GetMapping("/")
	public String index(Model m) {
		List<Employee> allEmp = employeeService.getAllEmp();  // Retrieve all employees
		m.addAttribute("empList", allEmp);	 // Add the employee list to the model
		return "index";  // Return the index view.
	}
	
	 /**
     * Displays the admin home page with a list of all employees.
     * @param m Model to hold the employee list
     * @return the name of the admin home view (indexadmin)
     */
	@GetMapping("/admin")
	public String indexadmin(Model m) {
		List<Employee> allEmp = employeeService.getAllEmp();	 // Retrieve all employees
		m.addAttribute("empList", allEmp); // Add the employee list to the model
		return "indexadmin";	 // Return the admin index view
	}
	
	/**
     * Loads the page for saving a new employee.
     * @return the name of the save view
     */
	@GetMapping("/loadempsave")
	public String Save() { 
		return "save"; // Return the save view
	}
	/**
     * Handles logout functionality for the admin user.
     * @param request HttpServletRequest for logout handling
     * @return redirect to the home page
     */
	@GetMapping("/logoutadmin" )
	public String adminlogout(HttpServletRequest request) { 
		try {
	        request.logout(); // Attempt to log out the user
	    } catch (ServletException e) {
	        
	        e.printStackTrace();// Print any exceptions to the console
	    }
		return "redirect:/"; // Redirect to the home page
	}
	
	   /**
     * Loads the edit page for a specific employee based on their ID.
     * @param id The ID of the employee to edit
     * @param m Model to hold the employee data
     * @return the name of the edit view
     */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable int id, Model m) {
		Employee emp = employeeService.getEmpById(id); // Retrieve employee by ID
		m.addAttribute("emp", emp);  // Add the employee to the model
		return "edit";   // Return the edit view
	}
	
	/**
     * Saves a new employee's details.
     * @param emp The Employee object to be saved
     * @param session HttpSession to store messages
     * @return redirect to the save employee page
     */
	@PostMapping("/saveEmp")
	public String saveEmp(@ModelAttribute Employee emp, HttpSession session) {
		Employee newEmp = employeeService.saveEmployee(emp);	// Save the employee
		 if(newEmp != null) { 
			 session.setAttribute("msg", "Register Sucessfully...");	 // Success message
		 }else {
			 session.setAttribute("msg", "Something wrong on server");	// Error message
		 }
		return "redirect:/loadempsave";		 // Redirect to the save employee page
	}
	
	/**
     * Updates an existing employee's details.
     * @param emp The Employee object containing updated details
     * @param session HttpSession to store messages
     * @return redirect to the admin home page
     */
	@PostMapping("/updateEmp")
	public String updateEmp(@ModelAttribute Employee emp, HttpSession session) {
		Employee updateEmp = employeeService.saveEmployee(emp); 	// Update the employee
		 if(updateEmp != null) {
			 session.setAttribute("msg", "Update Sucessfully...");  // Success message
		 }else {
			 session.setAttribute("msg", "Something wrong on server");    // Error message
		 } 
		return "redirect:/admin";   // Redirect to the admin home page
	}
	
	 /**
     * Deletes an employee based on their ID.
     * @param id The ID of the employee to delete
     * @param session HttpSession to store messages
     * @return redirect to the admin home page
     */
	@GetMapping("/deleteEmp/{id}")
	public String deleteemployee(@PathVariable int id, HttpSession session) {
		boolean f = employeeService.deleteEmp(id);	 // Attempt to delete the employee
		if(f) {
			session.setAttribute("msg", "Delete Sucessfully...");  // Success message
		}else {
			session.setAttribute("msg", "Something wrong on server"); // Error message
		}
		return "redirect:/admin"; 	 // Redirect to the admin home page
	}
}







