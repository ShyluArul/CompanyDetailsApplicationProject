package com.companydetails.model.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.companydetails.model.entities.Employer;

@Repository
public interface EmployerRepository extends JpaRepository<Employer, Long> {
	public Optional<Employer> findByEmployerId(Long id);
}
