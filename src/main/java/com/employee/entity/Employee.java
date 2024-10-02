package com.employee.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * Employee represents the entity for an employee in the system.
 * It maps to the employee table in the database.
 */

@Entity
public class Employee {
    // Unique identifier for the employee
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	// Name of the employee, must not be blank
	@NotBlank(message = "Name is Mandatory...")
	private String name;
	
	// Email of the employee, must be a valid email format
	@Email(message = "Email should be valid...")
	private String email;
	
	// Address of the employee, must not be blank
	@NotBlank(message = "Address is mandetory...")
	private String address;
	
    // Date of Birth of the employee, must not be null
	@NotNull(message = "Date of Birth is mandatory...")
    private LocalDate dateOfBirth;
	
    // Department of the employee, must not be null
	@NotNull(message = "Department is mandatory...")
	private String department;
	
    // Gender of the employee, must not be null
	@NotNull(message = "Please select a gender")
	private String gender;
	
    // Password of the employee, must not be blank
	@NotBlank(message = "Password cannot be blank")
	private String password;

    // Default constructor
	public Employee() {
	}
	
	
    // Parameterized constructor for creating an Employee object with all fields
	public Employee(int id, @NotBlank(message = "Name is Mandatory...") String name,
			@Email(message = "Email should be valid...") String email,
			@NotBlank(message = "Address is mandetory...") String address,
			@NotNull(message = "Date of Birth is mandatory...") LocalDate dateOfBirth,
			@NotNull(message = "Department is mandatory...") String department,
			@NotNull(message = "Please select a gender") String gender,
			@NotBlank(message = "Password cannot be blank") String password) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.address = address;
		this.dateOfBirth = dateOfBirth;
		this.department = department;
		this.gender = gender;
		this.password = password;
	}



    // Getters and Setters for each field
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}



	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}



	public String getDepartment() {
		return department;
	}



	public void setDepartment(String department) {
		this.department = department;
	}



	public String getGender() {
		return gender;
	}



	public void setGender(String gender) {
		this.gender = gender;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}


	/**
     * Returns a string representation of the Employee object.
     * @return a string containing the employee's details
     */
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", email=" + email + ", address=" + address + ", dateOfBirth="
				+ dateOfBirth + ", department=" + department + ", gender=" + gender + ", password=" + password + "]";
	}



	
	
	
}
