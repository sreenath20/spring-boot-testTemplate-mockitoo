package com.demo;

import com.demo.employee.Employee;
import com.demo.employee.EmployeeException;
import com.demo.employee.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EmployeeServiceIntegrationTests {

	@Autowired
	private EmployeeService employeeService;

	@Test
	void registerEmployeeTest() {
		Employee emp = new Employee(1,"Ford",25000.0);
		assertEquals("Ford",this.employeeService.registerEmployee(emp).getName());
	}
	@Test
	void getEmployeeByIdThrowsExceptionTest() {

		assertThrows(EmployeeException.class,()->this.employeeService.getEmployeeById(1000));
	}
}
