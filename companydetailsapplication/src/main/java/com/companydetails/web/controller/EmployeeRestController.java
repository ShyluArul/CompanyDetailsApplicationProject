package com.companydetails.web.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.companydetails.exceptionhandler.EmployeeNotFoundException;
import com.companydetails.model.entities.Employee;
import com.companydetails.service.EmployeeService;

@RestController
@RequestMapping(path = "/api")
public class EmployeeRestController {
	private EmployeeService employeeService;
	@Autowired
	public EmployeeRestController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	@GetMapping(path = "/employee/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employee> getAnEmployee(@PathVariable(name = "id") Long id) {
		Employee employee = employeeService.findByemployeeId(id).orElseThrow(EmployeeNotFoundException::new);
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	}
	@GetMapping(path = "/employeesalarygreaterthan/{employeeSalary}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Employee>> getGreateremployeeSalary(
			@PathVariable(name = "employeeSalary") double employeeSalary) {
		return new ResponseEntity<List<Employee>>(employeeService.getGreateremployeeSalary(employeeSalary),
				HttpStatus.OK);
	}
}
