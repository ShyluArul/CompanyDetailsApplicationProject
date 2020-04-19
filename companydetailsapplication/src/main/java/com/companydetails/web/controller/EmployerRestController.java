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
import com.companydetails.model.entities.Employer;
import com.companydetails.service.EmployerService;

@RestController
@RequestMapping(path = "/api")
public class EmployerRestController {
	private EmployerService employerService;
	@Autowired
	public EmployerRestController(EmployerService employerService) {
		this.employerService = employerService;
	}
	@GetMapping(path = "/employer", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Employer>> getAllEmployers() {
		return new ResponseEntity<List<Employer>>(employerService.getAllEmployer(), HttpStatus.OK);
	}
	@GetMapping(path = "/employer/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employer> getAnEmployer(@PathVariable(name = "id") Long id) {
		Employer employer = employerService.findByemployerId(id).orElseThrow(EmployeeNotFoundException::new);
		return new ResponseEntity<Employer>(employer, HttpStatus.OK);
	}
}
