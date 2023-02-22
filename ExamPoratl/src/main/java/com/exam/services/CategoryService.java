package com.exam.services;

import com.exam.model.exam.Category;

import java.util.Set;

public interface CategoryService {

//for add category
    public Category addCategory(Category category);

// for update category
    public Category updateCategory(Category category);

// for get all category
    public Set<Category> getCategories();

//    for get category by id
    public Category getCategory(Long categoryId);

//    For Delete category
    public void deleteCategory(Long categoryId);

//    Get Count of category
    public int totalCategory();
}
