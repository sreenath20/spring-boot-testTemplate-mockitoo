package com.demo.employee;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.*;
import java.time.LocalDate;

@Entity
@PropertySource("classpath:application.properties")
public class Employee {

    @NotNull(message = "Id cant be null")
    @Id
    private Integer id;

    //@NotNull(message = "Name cant be null")
    @NotBlank(message = "Name cant be null, it should contain chars")
    @Pattern(regexp = "[a-zA-Z ]{3,16}", message = "Name should contain min 3 & max 16 chars , no digits and special chars allowed.")
    private String name;

    @Email(message = "Please provide valid email. e.g name@ford.com")
    private String email;
    @Pattern(regexp = "[0-9]{3}",message = "Pin code should contain 3 digits")
    private String pin;
    @Pattern(regexp = "[0-9]{10}",message = "Tel no should contain only 10 digits")
    private String phoneNumber;
    //@Future
    @FutureOrPresent(message = "Join data cant be in pas")
    //@Past
    //@PastOrPresent

    private LocalDate dateOfJoining;
    @Value("${application.salary}")
    private Double salary;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDate getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(LocalDate dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    public Employee(Integer id, String name, String email, String pin, String phoneNumber, LocalDate dateOfJoining, Double salary) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.pin = pin;
        this.phoneNumber = phoneNumber;
        this.dateOfJoining = dateOfJoining;
        this.salary = salary;
    }

    public Employee() {

    }

    public Employee(Integer id, String name, Double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
