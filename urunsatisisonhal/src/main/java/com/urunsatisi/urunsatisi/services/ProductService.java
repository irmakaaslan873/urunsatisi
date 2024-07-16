package com.urunsatisi.urunsatisi.services;

import com.urunsatisi.urunsatisi.entities.Category;
import com.urunsatisi.urunsatisi.entities.Product;
import com.urunsatisi.urunsatisi.repository.CategoryRepository;
import com.urunsatisi.urunsatisi.repository.ProductRepository;
import com.urunsatisi.urunsatisi.request.ProductRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
    private CategoryService categoryService;


    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(int id) {
        return productRepository.findById(id).get();
    }

    public Product addProduct(ProductRequest request) {


     Long id=0L;
        categoryService.categoryNotFound(id);

        categoryExists(request.getProductName());

        Product product = Product.builder()
                .name(request.getProductName())
                .price(request.getPrice())
                .stock(request.getStock())
                .build();

        return productRepository.save(product);
    }

    public void deleteProduct(Integer id,ProductRequest request) {
      categoryforDelete(request.getProductName());
      productRepository.deleteById(id);
    }

    public Product updateProductById(Integer id, ProductRequest request) {
        Optional<Product> optionalProduct = productRepository.findById(id);

        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            product.setName(request.getProductName());
            product.setPrice(request.getPrice());
            product.setStock(request.getStock());
            return productRepository.save(product);
        } else {
            // Handle the case where the product is not found, e.g., throw an exception or return null
            return null;
        }
    }





    private void categoryExists(String name){
        if(productRepository.existsByName(name)){
            throw new IllegalArgumentException("product already exists");
        }
    }

    private void categoryforDelete(String name){
        if(name.isEmpty()){
            throw new IllegalArgumentException("Category  cannot be empty");
        }
    }

}

