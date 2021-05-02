package edu.asu.cse545.group5.SBS.service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.asu.cse545.group5.SBS.model.Customer;
import edu.asu.cse545.group5.SBS.repo.CustomerRepo;

@Service
@Transactional
public class CustomerService {

    private final CustomerRepo customerRepo;

    @Autowired
    public CustomerService(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }
    
    public Customer addCustomer(Customer customer) {
        String fName = customer.getFirstName();
        String lName = customer.getLastName();
        customer.setUsername(generatePrimaryKey(fName, lName));
        return customerRepo.save(customer);
    }

    public List<Customer> findAllCustomer() {
         return customerRepo.findAll();
    }

    public Customer updateCustomer(Customer customer) {
        return customerRepo.save(customer);
    }

    public Customer findCustomerByUsername(String username) throws Exception {
        return customerRepo.findCustomerByUsername(username).orElseThrow(() -> new Exception("User not found"));
    }

    public void deleteCustomer(String username) {
         customerRepo.deleteCustomerByUsername(username);
    }

    public Customer getCustomer(String username) {
        Optional<Customer> customer = customerRepo.findById(username);
        if (customer.isPresent()) {
            return customer.get();
        } else {
            return null;
        }
    }

    public String generatePrimaryKey(String fName, String lName) {
        String firstInitial = fName.substring(0, 1);
        String key = firstInitial.toLowerCase() + lName.toLowerCase();
        return getFirstAvailablePrimaryKey(key);
    }

    public String getFirstAvailablePrimaryKey(String skeletonKey) {
        String skeletonKeySearch = "%" + skeletonKey + "%";
        List<String> customers = customerRepo.findCustomersByUsernameContaining(skeletonKeySearch);
        System.out.println(customers.size());
        int suffix = new Random().nextInt(900) + 100;
        if (customers.size() != 0) {
            for (String key: customers) {
                key.replaceAll(skeletonKey, "");
            }
            while(customers.contains(Integer.toString(suffix))) {
                suffix = new Random().nextInt(900) + 100;
            }
        }
        return skeletonKey + Integer.toString(suffix);
    }
}
