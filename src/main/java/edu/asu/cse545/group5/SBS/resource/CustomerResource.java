package edu.asu.cse545.group5.SBS.resource;

import edu.asu.cse545.group5.SBS.model.Customer;
import edu.asu.cse545.group5.SBS.service.CustomerService;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerResource {
    private final CustomerService customerService;
    public CustomerResource(CustomerService customerService) {
        this.customerService = customerService;
    }
    @PostMapping("/createCustomer")
    public ResponseEntity<Customer> createAccount(@RequestBody Customer customer) {
        Customer newCustomer = customerService.addCustomer(customer);
        return new ResponseEntity<>(newCustomer, HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Customer>> getAllCustomers() {
        List<Customer> customer = customerService.findAllCustomer();
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @GetMapping("/getCustomer/{username}")
    public ResponseEntity<Customer> getCustomerByUsername (@PathVariable("username") String username) throws Exception {
        Customer customer = customerService.findCustomerByUsername(username);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @PutMapping("/updateCustomer") 
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer) {
        Customer updateCustomer = customerService.updateCustomer(customer);
        return new ResponseEntity<>(updateCustomer, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{username}")
    public ResponseEntity<?> deleteCustomer(@PathVariable("username") String username){
        customerService.deleteCustomer(username);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}