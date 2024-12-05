package com.emp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.emp.binding.LoginRequest;
import com.emp.entity.Employee;
import com.emp.service.EmpService;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class EmpController {

	@Autowired
	private EmpService service;

	@PostMapping("/register")
	public ResponseEntity<String> registerEmp(@RequestBody Employee emp) {
		return ResponseEntity.ok(service.registerEmployee(emp));
	}

	@PostMapping("/login")
	public ResponseEntity<?> loginEmp(@RequestBody LoginRequest loginRequest) {
		String email = loginRequest.getEmail();
		String password = loginRequest.getPassword();
		Employee emp = service.loginEmployee(email, password);
		if (emp != null) {
			return ResponseEntity.ok(emp);
		}
		return ResponseEntity.status(401).body("Invalid credentials");
	}

}
