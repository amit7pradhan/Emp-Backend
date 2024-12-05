package com.emp.entity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpRepositary extends JpaRepository<Employee, Integer> {

	boolean existsByEmail(String email);

	Employee findByEmail(String email);

}
