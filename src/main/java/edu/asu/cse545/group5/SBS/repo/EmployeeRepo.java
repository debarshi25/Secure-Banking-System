package edu.asu.cse545.group5.SBS.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.asu.cse545.group5.SBS.model.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {

    //@Query(value = "SELECT * FROM employees WHERE employeeId = :employeeId", nativeQuery = true)
    Optional<Employee> findEmployeeByEmployeeId(Long employeeId);
      
    void deleteEmployeeByEmployeeId(Long employeeId);
    
}
