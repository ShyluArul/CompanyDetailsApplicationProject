package com.companydetails.model.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.companydetails.model.entities.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	public Optional<Employee> findByemployeeId(Long employeeId);
}
