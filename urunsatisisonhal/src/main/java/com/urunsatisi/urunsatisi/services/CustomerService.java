package com.urunsatisi.urunsatisi.services;

import com.urunsatisi.urunsatisi.entities.Customer;
import com.urunsatisi.urunsatisi.entities.Product;
import com.urunsatisi.urunsatisi.repository.CustomerRepository;
import com.urunsatisi.urunsatisi.request.CustomerRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer getCustomerByName(String name) {
        return customerRepository.findByName(name);
    }

    public Integer calculateAge(int yearofBirth) {
        return 2024-yearofBirth;
    }

    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }

    public Customer addCustomer(CustomerRequest request) {
        Customer customer = new Customer();
        customer.setName(request.getCustomerName());
        return  customerRepository.save(customer);
    }

    public void deleteCustomerById(int id) {
        customerRepository.deleteById(id);
    }

    public Customer updateCustomerById(int id, CustomerRequest request) {
        Customer customer = customerRepository.findById(id).get();
        customer.setName(request.getCustomerName());
        return customerRepository.save(customer);
    }
}

