package com.demo;

import com.demo.employee.Employee;

import com.demo.employee.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class EmployeeRepositoryTests {

    @Autowired
    private EmployeeRepository employeeRepository;

    @BeforeEach
    public void init() {
        employeeRepository.save(new Employee(1, "Ford", 25000.0));
    }

    @Test
    public void deleteEmployeeTest() {
        Optional<Employee> empOPt = employeeRepository.findById(1);

        Employee emp = empOPt.get();
        employeeRepository.delete(emp);
        assertEquals(true, employeeRepository.findById(1).isEmpty());
    }
}
