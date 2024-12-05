package com.emp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp.entity.EmpRepositary;
import com.emp.entity.Employee;

@Service
public class EmpService {

	@Autowired
	private EmpRepositary repo;
	
	public String registerEmployee(Employee emp) {
		if(repo.existsByEmail(emp.getEmail())) {
			return "Email already exists!";
		}
		repo.save(emp);
		return "User registered successfully!";
	}
	
	public Employee loginEmployee(String email,String password) {
		Employee emp=repo.findByEmail(email);
		if(emp!=null && emp.getPassword().equals(password)) {
			return emp;
		}
		return null;
	}
	
	
}
