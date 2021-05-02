package edu.asu.cse545.group5.SBS.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.asu.cse545.group5.SBS.model.EmployeeRequest;

public interface EmployeeRequestRepo extends JpaRepository<EmployeeRequest, Long> {
    
}
