package com.demo;

import com.demo.employee.Employee;
import com.demo.employee.EmployeeException;
import com.demo.employee.EmployeeRepository;
import com.demo.employee.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EmployeeControllerTestsByMockService {
    @Value(value = "${local.server.port}")
    private int port;


    @Autowired
    private TestRestTemplate testRestTemplate;

    @MockBean
    private EmployeeService employeeService;

    @Test
    public void demoTest2() throws EmployeeException {

        when(this.employeeService.getAllEmployees()).thenReturn(new ArrayList<>());

        List<Employee> foundEmployees = this.testRestTemplate.getForObject("http://localhost:" + port + "/v1/employees", ArrayList.class);
        assertEquals(true, foundEmployees.isEmpty());
        // assertEquals("Ford", employeeService.getEmployeeById(100).getName());
    }


}
