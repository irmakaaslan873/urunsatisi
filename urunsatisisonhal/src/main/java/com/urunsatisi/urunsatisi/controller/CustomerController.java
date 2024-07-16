package com.urunsatisi.urunsatisi.controller;

import com.urunsatisi.urunsatisi.entities.Customer;
import com.urunsatisi.urunsatisi.entities.Product;
import com.urunsatisi.urunsatisi.request.CustomerRequest;
import com.urunsatisi.urunsatisi.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public List<Customer> getAllCustomer() {
        return customerService.getAllCustomer();
    }


    @GetMapping("/name")
    public Customer getCustomer(@RequestParam String name) {
        return customerService.getCustomerByName(name);
    }

    @GetMapping("/age")
    ResponseEntity<String> getCustomerAge(@RequestParam Integer yearofBirth) {
        int age = customerService.calculateAge(yearofBirth);
        String responseMessage = "Your age is " + age;
        return new ResponseEntity<>(responseMessage, HttpStatus.OK);
    }
    @PostMapping("/add")
    public Customer addCustomer(@RequestBody CustomerRequest request) {
        return customerService.addCustomer(request);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteCustomerById(@PathVariable int id) {
        customerService.deleteCustomerById(id);
    }
    @PutMapping("/customer/{id}")
    public Customer updateCustomer(@PathVariable int id, @RequestBody CustomerRequest request) {
        return customerService.updateCustomerById(id,request);
    }



}
