package com.demo;

import com.demo.employee.Employee;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	// made some changes
	public static void main(String[] args) {

		SpringApplication.run(DemoApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		Employee emp = new Employee();
		System.out.println(emp.getSalary());
	}
}
