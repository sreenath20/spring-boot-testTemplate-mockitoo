package com.demo.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee registerEmployee(Employee newEmployee) {
        return this.employeeRepository.save(newEmployee);
    }

    @Override
    public Employee getEmployeeById(Integer employeeId) throws EmployeeException {
        Optional<Employee> employeeOptional = this.employeeRepository.findById(employeeId);
        if (employeeOptional.isEmpty())
            throw new EmployeeException("Employee Id does not exists.");

        return employeeOptional.get();
    }

    @Override
    public Employee updateEmployee(Employee employee) throws EmployeeException {
        Optional<Employee> employeeOptional = this.employeeRepository.findById(employee.getId());
        if (employeeOptional.isEmpty())
            throw new EmployeeException("Employee could not be updated, not found id:" + employee.getId());
        return this.employeeRepository.save(employee);
    }

    @Override
    public Employee deleteEmployeeById(Integer employeeId) throws EmployeeException {
        Optional<Employee> employeeOptional = this.employeeRepository.findById(employeeId);
        if (employeeOptional.isEmpty())
            throw new EmployeeException("Employee could not be Deleted, not found id:" + employeeId);
        Employee foundEmployee = employeeOptional.get();
        this.employeeRepository.delete(foundEmployee);
        return foundEmployee;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return this.employeeRepository.findAll();
    }
}
