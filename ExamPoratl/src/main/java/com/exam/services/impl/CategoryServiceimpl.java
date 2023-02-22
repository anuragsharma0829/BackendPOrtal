package com.exam.services.impl;

import com.exam.model.exam.Category;
import com.exam.repository.CategoryRepository;
import com.exam.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Set;

@Service
public class CategoryServiceimpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category addCategory(Category category) {
        return this.categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(Category category) {
        return this.categoryRepository.save(category);
    }

    @Override
    public Set<Category> getCategories() {
       return new LinkedHashSet<>(this.categoryRepository.findAll());
    }

    @Override
    public Category getCategory(Long categoryId) {
       return this.categoryRepository.findById(categoryId).get();
    }

    @Override
    public void deleteCategory(Long categoryId) {
        this.categoryRepository.deleteById(categoryId);
    }

//    Totel Category
    @Override
    public int totalCategory() {
       return this.categoryRepository.toatlCategory();
    }


}
