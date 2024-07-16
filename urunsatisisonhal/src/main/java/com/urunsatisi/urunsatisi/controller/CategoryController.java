package com.urunsatisi.urunsatisi.controller;

import com.urunsatisi.urunsatisi.entities.Category;
import com.urunsatisi.urunsatisi.request.CategoryRequest;
import com.urunsatisi.urunsatisi.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService; // değişken adı düzeltildi

    @GetMapping
    public List<Category> getAllCategory() {
        return categoryService.getAllCategory();
    }

    @GetMapping("/{id}")
    public Category getCategory(@PathVariable Long id) {
        return categoryService.getCategoryById(id);
    }

    //defensive programming
    @PostMapping("/add")
    public Category add(@RequestBody CategoryRequest request) {
        return categoryService.add(request);
    }

    @DeleteMapping("/delete/{id}") // path pattern düzeltildi
    public void delete(@PathVariable Long id, @RequestBody CategoryRequest request) {
        categoryService.delete(id,request);
    }

    @PutMapping("/category/{id}")
    public Category updateCategory(@PathVariable Long id, CategoryRequest request){
        return categoryService.updateCategory(id,request);
    }
}
