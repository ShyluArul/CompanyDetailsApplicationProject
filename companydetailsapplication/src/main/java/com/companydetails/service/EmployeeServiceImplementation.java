package com.companydetails.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.companydetails.model.entities.Employee;
import com.companydetails.model.repository.EmployeeRepository;

@Service
@Transactional
public class EmployeeServiceImplementation implements EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;
	@Override
	public Optional<Employee> findByemployeeId(Long id) {
		return employeeRepository.findById(id);
	}
	@Override
	public List<Employee> getGreateremployeeSalary(double employeeSalary) {
		List<Employee> getGreateremployeeSalary = (List<Employee>) employeeRepository.findAll();
		return getGreateremployeeSalary.stream().filter(p -> p.getEmployeeSalary() > employeeSalary)
				.collect(Collectors.toList());
	}
}
