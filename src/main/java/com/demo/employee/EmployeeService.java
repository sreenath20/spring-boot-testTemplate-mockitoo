package com.demo.employee;

import java.util.List;

public interface EmployeeService {
    Employee registerEmployee(Employee newEmployee);
    Employee getEmployeeById(Integer employeeId)throws EmployeeException;
    Employee updateEmployee(Employee employee)throws EmployeeException;
    Employee deleteEmployeeById(Integer employeeId) throws EmployeeException;
    List<Employee> getAllEmployees();
}
