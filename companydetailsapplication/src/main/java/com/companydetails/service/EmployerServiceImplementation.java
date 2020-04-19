package com.companydetails.service;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.companydetails.model.entities.Employer;
import com.companydetails.model.repository.EmployerRepository;

@Service
@Transactional
public class EmployerServiceImplementation implements EmployerService {
	@Autowired
	private EmployerRepository employerRepository;
	@Override
	public List<Employer> getAllEmployer() {
		return employerRepository.findAll();
	}
	@Override
	public Optional<Employer> findByemployerId(Long id) {
		return employerRepository.findById(id);
	}
}
