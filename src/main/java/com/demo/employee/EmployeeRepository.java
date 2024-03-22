package com.demo.employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    //Creation of custom queries by method name using keyWords

    List<Employee> findByName(String name);

    List<Employee> findByNameContaining(String name);

    List<Employee> findBySalaryBetweenOrderByNameDesc(Double minSalary, Double maxSalary);

    List<Employee> findBySalaryBetweenOrderByNameAsc(Double minSalary, Double maxSalary);

    List<Employee> findBySalaryBetweenOrderBySalaryDesc(Double minSalary, Double maxSalary);

    // By writing JPQL Queries
    @Query("SELECT employee FROM Employee employee")
    List<Employee> getAllEmployees();

    @Query("SELECT employee FROM Employee employee WHERE employee.name LIKE :name")
    List<Employee> getAllEmployeesHavingNameLike(String name);
}
