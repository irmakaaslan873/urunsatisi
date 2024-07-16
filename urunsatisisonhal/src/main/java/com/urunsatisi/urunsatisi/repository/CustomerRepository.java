package com.urunsatisi.urunsatisi.repository;

import com.urunsatisi.urunsatisi.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    Customer findByName(String name);
}
