package com.urunsatisi.urunsatisi.services;

import com.urunsatisi.urunsatisi.entities.Category;
import com.urunsatisi.urunsatisi.repository.CategoryRepository;
import com.urunsatisi.urunsatisi.request.CategoryRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    //ADD
    //UPDATE
    //DELETE
    //GETBYID
    //GETALL

    //n layered arch. Katmanlı Mimari

    //TODO: Business Rules

    //todo: Aynı isimde birden fazla kategori olamaz. bitti
    //todo: Aynı isimde birden fazla ürün olamaz. bitti
    //todo: Sistemde kaydı olmayan bir kategori silinmemeli ve güncellenmemeli. BİTTİ
    //todo: Sistemde kaydı olmayan bir ürün silinmemeli ve güncellenmemeli. BİTTİ
    //todo: Sistemde kaydı olmayan bir kategoriye ürün eklenemez. bitti
    //todo: Ürün eklenirken ürün ismi 3 karakterden az olamaz. bitti
    //todo: Ürün eklenirken price bilgisi 0 olmamalıdır.  bitti
    //todo: Ürün eklenirken stock bilgisi 0 olmamalıdır.   bitti

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAllCategory() {
        return categoryRepository.findAll();
    }

    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    public Category add(CategoryRequest request) {

        categoryNameShouldNotRepeatWhenCategoryAdd(request.getCategoryName());        //

        Category category = Category.builder().name(request.getCategoryName()).build();
        return categoryRepository.save(category);
    }

    public void delete(Long id, CategoryRequest request) {

        categoryNotFound(request.getCategoryId());

        categoryRepository.deleteById(id);
    }


    public Category updateCategory(Long id, CategoryRequest request) {

        categoryNotFound(request.getCategoryId());
        Category category = new Category();
        category.setName(request.getCategoryName());
        return categoryRepository.save(category);
    }

    private void categoryNameShouldNotRepeatWhenCategoryAdd(String categoryName){

        if (categoryRepository.existsByName(categoryName)) {
            throw new IllegalArgumentException("Category name must be unique.");
        }
    }
    public void categoryNotFound(Long id){
        Optional<Category> category = categoryRepository.findById(id);
        if (category.isEmpty()) {
            throw new IllegalArgumentException("Category not found.");
        }
    }
}