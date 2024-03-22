package com.demo;

import com.demo.employee.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EmployeeControllerTests {

    @Value(value="${local.server.port}")
    private int port;

    @Autowired
    private TestRestTemplate restTestTemplate;

    @BeforeEach
    public void init(){
        this.restTestTemplate.postForObject("http://localhost:" + port + "/v1/employee",new Employee(1,"India",25000.0), Employee.class);
    }

    @Test
    public void greetingShouldReturnDefaultMessage() throws Exception {
        assertThat(this.restTestTemplate.getForObject("http://localhost:" + port + "/v1/",
                String.class)).contains("Welcome to my demo spring boot application !");
    }

    @Test
    public void getEmployeeByIdTest() throws Exception {
        Employee foundEmployee =this.restTestTemplate.getForObject("http://localhost:" + port + "/v1/employee/1", Employee.class);
        assertEquals("India",foundEmployee.getName());
    }

    @Test
    public void getEmployeeByIdExceptionTest() throws Exception {
        String employeeExceptionMessage =this.restTestTemplate.getForObject("http://localhost:" + port + "/v1/employee/2", String.class);
        assertEquals("Employee Id does not exists.",employeeExceptionMessage);
    }
}
