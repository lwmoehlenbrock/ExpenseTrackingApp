package com.example.reacttutorial.expensetracker.controller;

import com.example.reacttutorial.expensetracker.Services.CategoryService;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.example.reacttutorial.expensetracker.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/getAllCategories")
    Collection<Category> categories(){
        return categoryService.getCategories();
    }

    @PostMapping("/addCategory")
    void addCategory(@RequestBody ObjectNode objectNode){
        String name = objectNode.get("name").toString();
        name = name.substring(1, name.length()-1);
        Category category = new Category();
        category.setName(name);
        System.out.println(category.toString());
        categoryService.addCategory(category);
        System.out.println(category.toString());


    }

    @DeleteMapping("/removeCategory/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable("id") Long id){
        categoryService.removeCategory(id);
        return ResponseEntity.ok().build();
    }
}
