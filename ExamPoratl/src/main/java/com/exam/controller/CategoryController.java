package com.exam.controller;

import com.exam.model.exam.Category;
import com.exam.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
@CrossOrigin("*")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

//    Add Category
    @PostMapping("/")
  public ResponseEntity<Category> addCategory(@RequestBody Category category)
  {
   Category category1= this.categoryService.addCategory(category);
   return ResponseEntity.ok(category1);
  }

//  Get Category by ID

     @GetMapping("/{cid}")
    public ResponseEntity<?> getCategory(@PathVariable("cid") Long categoryId)
     {
         Category category=this.categoryService.getCategory(categoryId);
         return ResponseEntity.ok(category);
     }

//     Get  All Category
      @GetMapping("/")
    public ResponseEntity<?> getCategories()
    {
       return ResponseEntity.ok(this.categoryService.getCategories());
    }

//    Put mapping
    @PutMapping("/")
    public ResponseEntity<Category> updateCategory(@RequestBody Category category)
    {
        Category category1=this.categoryService.updateCategory(category);
        return ResponseEntity.ok(category1);
    }

//    Delete Category
    @DeleteMapping("/{cid}")
    public void deleteCAtegory(@PathVariable("cid") Long cid)
    {
        this.categoryService.deleteCategory(cid);
    }

//Get Total category
    @GetMapping("/ctotal")
    public ResponseEntity<?> getTotalCategory(){
        int Total= this.categoryService.totalCategory();
        return ResponseEntity.ok(Total);
    }


}
