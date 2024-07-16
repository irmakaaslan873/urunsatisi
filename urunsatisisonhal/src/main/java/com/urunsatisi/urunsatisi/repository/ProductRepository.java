package com.urunsatisi.urunsatisi.repository;

import com.urunsatisi.urunsatisi.entities.Category;
import com.urunsatisi.urunsatisi.entities.Customer;
import com.urunsatisi.urunsatisi.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    boolean existsByName(String name);
}