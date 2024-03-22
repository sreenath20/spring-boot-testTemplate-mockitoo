package com.demo.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

//localhost:8090/swagger-ui.html

@RestController
@RequestMapping(value = "/v1") //
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService ;

    @RequestMapping(method = RequestMethod.GET, value = "/")
   // @GetMapping("/")
    public String greet(){
        return "Welcome to my demo spring boot application !";
    }

    @GetMapping("/employee/{id}")
    public Employee getEmployeeById(@PathVariable Integer id) throws EmployeeException{

        //return "get employee by id"+id;
        return employeeService.getEmployeeById(id);
    }

    //@RequestMapping(method = RequestMethod.POST, value = "/employee")
    @PostMapping("/employee") // bind incoming JSON data and parameter
    @ResponseStatus(value = HttpStatus.CREATED)
    public Employee addResource(@Valid @RequestBody Employee employee){
       // System.out.println(employee);
        //return employee;
        return employeeService.registerEmployee(employee);
    }

    @PutMapping("/employee") // update employee
    public Employee replaceResource(@RequestBody Employee employee) throws EmployeeException {
      //  return "Put request !"+employee;
    return employeeService.updateEmployee(employee);
    }

    @DeleteMapping("/employee/{employeeId}")// URl template
    public Employee deleteResource(@PathVariable("employeeId") Integer employeeId ) throws EmployeeException {
        //return "Delete !"+employeeId;
        return employeeService.deleteEmployeeById(employeeId);
    }
    //localhost:8090/employee/1/name/India
    @PatchMapping("/employee/{id}/name/{employeeName}")// partial update od resource
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public String updateResourceName(@PathVariable("id") Integer employeeId,@PathVariable("employeeName") String employeeName){
        return "Patch !"+employeeId+":"+employeeName;
    }

    @GetMapping("employees")
    public List<Employee> getAllEmployees(){
        return this.employeeService.getAllEmployees();
    }

    @Autowired
    private EmployeeRepository employeeRepository;
    @GetMapping("employees/name/{name}")
    public List<Employee> getAllEmployeesHavingName(@PathVariable("name") String name){
        return this.employeeRepository.findByName(name);
    }
    @GetMapping("employees/contain/{name}")
    public List<Employee> getAllEmployeesContainingName(@PathVariable("name") String name){
        return this.employeeRepository.findByNameContaining(name);
    }

    @GetMapping("employees/salary/{minSalary}/{maxSalary}")
    public List<Employee> findAllEmployeesHavingSalaryBetween(@PathVariable("minSalary") Double minSalary,
                                                              @PathVariable("maxSalary")Double maxSalary){
        return this.employeeRepository.findBySalaryBetweenOrderBySalaryDesc(minSalary,maxSalary);

    }

    @GetMapping("custom/employees")
    public List<Employee> findAllEmployees(){
        return this.employeeRepository.getAllEmployees();
    }

    @GetMapping("custom/employees/{name}")
    public List<Employee> findAllEmployeesHavingName(@PathVariable("name") String name){
        return this.employeeRepository.getAllEmployeesHavingNameLike("%"+name+"%");
    }

}
