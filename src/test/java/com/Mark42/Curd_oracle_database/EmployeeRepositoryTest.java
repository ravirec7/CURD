package com.Mark42.Curd_oracle_database;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.data.repository.support.Repositories;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
public class EmployeeRepositoryTest {
	
	 @Autowired
	 private TestEntityManager entityManager;
	 
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Test
    public void testSaveNewProduct() {
        entityManager.persist(new Employee("Ram", 1099));
                 
        Employee product = employeeRepository.findByName("Ram");
         
        assertThat(product.getName()).isEqualTo("Ram");
    }
    
 //Test Create operation:
    
    @Test
    @Order(1)
    @Rollback(false)
    public void testSaveEmployee() {
        Employee savedEmployee = employeeRepository.save(new Employee("Ram", 789));
         
        assertThat(savedEmployee.getId()).isGreaterThan(0);
    }
    
//    Test Update Operation:
    
    @Test
    @Order(2)
    @Rollback(false)
    public void testUpdateEmployee() {
        Employee employee = employeeRepository.findByName("Ram");
        employee.setSalery(1000);
         
        employeeRepository.save(employee);
         
        Employee updatedEmployee = employeeRepository.findByName("Ram");
         
        assertThat(updatedEmployee.getSalery()).isEqualTo(1000);
    }
    
//    Test Delete Operation:
    
    @Test
    @Order(3)
    @Rollback(false)
    public void testDeleteProduct() {
        Employee employee = employeeRepository.findByName("Ram");
         
        employeeRepository.deleteById(employee.getId());
         
        Employee deletedEmployee = employeeRepository.findByName("Ram");
         
        assertThat(deletedEmployee).isNull();       
         
    }
    
}
	
	


