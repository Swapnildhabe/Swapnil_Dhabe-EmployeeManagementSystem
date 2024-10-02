package com.employee.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class LoginController {
		
	/**
	 * LoginController handles the login functionality for users.
	 */
	  @GetMapping("/login")
	    public String login() {
	        return "login";  // Return the login view
	    }
}
