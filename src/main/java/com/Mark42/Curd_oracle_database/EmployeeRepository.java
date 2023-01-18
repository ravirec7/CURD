package com.Mark42.Curd_oracle_database;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	public Employee findByName(String name);

	

}
