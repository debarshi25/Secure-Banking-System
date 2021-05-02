package edu.asu.cse545.group5.SBS.resource;

import edu.asu.cse545.group5.SBS.model.Employee;
import edu.asu.cse545.group5.SBS.service.EmployeeService;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeResource {

    private final EmployeeService employeeService;
    public EmployeeResource(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    
    @PostMapping("/addEmployee")
    public ResponseEntity<Employee> createAccount(@RequestBody Employee employee) {
        Employee newEmployee = employeeService.addEmployee(employee);
        return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Employee>> getAllEmployee() {
        List<Employee> employees = employeeService.findAllEmployee();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/getEmployee/{employeeId}")
    public ResponseEntity<Employee> getEmployeeById (@PathVariable("employeeId") Long id) throws Exception {
        Employee employee = employeeService.findEmployeeByEmployeeId(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PutMapping("/updateEmployee") 
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
        Employee updateEmployee = employeeService.updateEmployee(employee);
        return new ResponseEntity<>(updateEmployee, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{employeeId}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("employeeId") Long employeeId){
        employeeService.deleteEmployee(employeeId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}