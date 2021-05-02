package edu.asu.cse545.group5.SBS.service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.asu.cse545.group5.SBS.model.Employee;
import edu.asu.cse545.group5.SBS.repo.EmployeeRepo;

@Service
@Transactional
public class EmployeeService {

    private final EmployeeRepo employeeRepo;

    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public Employee addEmployee(Employee employee) {
        employee.setEmployeeId(generatePrimaryKey());
        return employeeRepo.saveAndFlush(employee);
    } 

    public List<Employee> findAllEmployee() {
         return employeeRepo.findAll();
    }

    public Employee updateEmployee(Employee employee) {
        return employeeRepo.saveAndFlush(employee);
    }

    public Employee findEmployeeByEmployeeId(Long employeeId) throws Exception {
        return employeeRepo.findEmployeeByEmployeeId(employeeId).orElseThrow(() -> new Exception("User not found"));
    }

    public void deleteEmployee(Long employeeId) {
         employeeRepo.deleteEmployeeByEmployeeId(employeeId);
    }

    public long generatePrimaryKey() {
        long key = new Random().nextInt(90000000) + 10000000;
        while (isPrimaryKeyAvailable(key) == false) {
            key = new Random().nextInt(90000000) + 10000000;
        }
        return key;
    }

    public boolean isPrimaryKeyAvailable(long primaryKey) {
        Optional<Employee> employee = employeeRepo.findEmployeeByEmployeeId(primaryKey);
        boolean isKeyAvailable = !(employee.isPresent());
        if (isKeyAvailable) {
            return true;
        } else {
            return false;
        }
    }
}
