package com.example.reacttutorial.expensetracker.Services;

import com.example.reacttutorial.expensetracker.model.Category;
import com.example.reacttutorial.expensetracker.model.Expense;
import com.example.reacttutorial.expensetracker.repositories.CategoryRepository;
import com.example.reacttutorial.expensetracker.repositories.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;
import java.util.List;

@Service
public class ExpenseService {

    @Autowired
    ExpenseRepository expenseRepository;

    @Autowired
    CategoryRepository categoryRepository;

    public List<Expense> getExpenses(){
        return expenseRepository.findAll();
    }

    public Expense addExpense(Expense expense){
        return expenseRepository.save(expense);
    }

    public void removeExpense(Long id){
        expenseRepository.deleteById(id);
    }

    public List<Expense> searchByName(String name){
        return expenseRepository.findByDescription(name);
    }

    public List<Expense> searchByCategory(String categoryName){
        List<Category> categories = categoryRepository.findAll();
        Category categoryForSearch = new Category();
        for(Category category:categories){
            if(category.getName().equals(categoryName)){
                categoryForSearch = category;
            }
        }
        return expenseRepository.findByCategory(categoryForSearch);
    }

    public List<Expense> searchByDate(Instant date){
        return expenseRepository.findByDate(date);
    }
}
