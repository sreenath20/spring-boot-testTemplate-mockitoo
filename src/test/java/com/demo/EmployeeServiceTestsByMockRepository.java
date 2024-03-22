package com.demo;

import com.demo.employee.*;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
public class EmployeeServiceTestsByMockRepository {

    @MockBean
    private EmployeeRepository employeeMockRepository;

//    @Autowired
@MockBean
    private EmployeeService employeeService;


    @Test
    public void demoTest2() throws EmployeeException {

        when(this.employeeService.getAllEmployees()).thenReturn(new ArrayList<>());
        when(this.employeeMockRepository.findById(100))
                .thenReturn(Optional.of(new Employee(100, "Ford", 2500.0)));

        assertEquals("Ford", employeeService.getEmployeeById(100).getName());
    }
    @Test
    public void testServiceWithOutActualRepository() throws EmployeeException {

        when(this.employeeMockRepository.findById(100))
                .thenReturn(Optional.of(new Employee(100, "Ford", 2500.0)));

        assertEquals("Ford", employeeService.getEmployeeById(100).getName());
    }

    @Test
    public void testGetEmployeeThrowsExceptionTest() throws EmployeeException {

      when(this.employeeMockRepository.findById(200))
                .thenReturn(Optional.empty());


        assertThrows(EmployeeException.class, () -> employeeService.getEmployeeById(200));
        try {
            employeeService.getEmployeeById(200);
        } catch (Exception e) {
            assertEquals("Employee Id does not exists.", e.getMessage());
        }

    }
}
