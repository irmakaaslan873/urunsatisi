package com.urunsatisi.urunsatisi.controller;

import com.urunsatisi.urunsatisi.entities.Product;
import com.urunsatisi.urunsatisi.request.ProductRequest;

import com.urunsatisi.urunsatisi.services.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable int id) {
        return productService.getProductById(id);
    }

    @PostMapping("/add")
    public Product addProduct(@RequestBody @Validated ProductRequest request) {
        return productService.addProduct(request);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProduct(@PathVariable Integer id,@RequestBody ProductRequest request) {
        productService.deleteProduct(id,request);
    }

    @PutMapping("/products/{id}")
    public Product updateProduct(@PathVariable int id, @RequestBody ProductRequest request) {
        return productService.updateProductById(id, request);
    }

}
