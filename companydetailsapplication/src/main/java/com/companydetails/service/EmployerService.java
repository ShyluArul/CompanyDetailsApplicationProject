package com.companydetails.service;

import java.util.List;
import java.util.Optional;
import com.companydetails.model.entities.Employer;

public interface EmployerService {
	public List<Employer> getAllEmployer();
	public Optional<Employer> findByemployerId(Long id);
}
