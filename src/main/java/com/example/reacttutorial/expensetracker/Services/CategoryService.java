package com.example.reacttutorial.expensetracker.Services;

import com.example.reacttutorial.expensetracker.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.reacttutorial.expensetracker.repositories.CategoryRepository;

import java.util.Collection;
import java.util.Optional;
import java.util.List;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    public Collection<Category> getCategories(){
        return categoryRepository.findAll();
    }

    public void addCategory(Category category){
        List<Category> categories = categoryRepository.findAll();
        for(Category cat:categories){
            if (cat.getName().equals(category.getName())){
                return;
            }
        }
        categoryRepository.save(category);
    }

    public void removeCategory(Long id){
        categoryRepository.deleteById(id);
    }
}
