package com.Mark42.Curd_oracle_database;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.Getter;
import lombok.Setter;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository repo;
	
	@PostMapping("/save")
	public ResponseEntity<String> saveEmployee(@RequestBody Employee employee){
		try {
		repo.save(employee);
		}
		catch(Exception e) {
			return new ResponseEntity<String>("Not inserted",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<String>("SuccessFully inserted",HttpStatus.OK);
	}
	@GetMapping("/selectAll")
	public ResponseEntity<List<Employee>> getEmployee(){
		List<Employee> list = null;
		try {
			list = repo.findAll();
		}
		catch(Exception e) {
			return new ResponseEntity<List<Employee>>(list,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<List<Employee>>(list,HttpStatus.OK);
	}
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity<String> getEmployee(@PathVariable("id") int id){
		try {
		repo.deleteById(id);
		}
		catch(Exception e) {
			return new ResponseEntity<String>("not Delete",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<String>("successfully Delete",HttpStatus.OK);
		
	}
	@PutMapping("/updete")
	public String updateEmp(@RequestBody Employee emp) {
		Optional<Employee> temp = repo.findById(emp.getId());
		Employee employee = temp.get();
		//swapping
		employee.setName(emp.getName());
		employee.setSalery(emp.getSalery());
		repo.save(employee);
		return "Successfully updated";
		
	}

}
