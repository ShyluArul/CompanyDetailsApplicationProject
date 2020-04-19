package com.companydetails.service;

import java.util.List;
import java.util.Optional;
import com.companydetails.model.entities.Employee;

public interface EmployeeService {
	public Optional<Employee> findByemployeeId(Long id);
	public List<Employee> getGreateremployeeSalary(double employeeSalary);
}
