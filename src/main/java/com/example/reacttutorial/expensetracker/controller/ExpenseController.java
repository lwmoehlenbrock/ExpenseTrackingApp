package com.example.reacttutorial.expensetracker.controller;

import com.example.reacttutorial.expensetracker.Services.ExpenseService;
import com.example.reacttutorial.expensetracker.model.Category;
import com.example.reacttutorial.expensetracker.model.Expense;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.Instant;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/expenses")
public class ExpenseController {

    @Autowired
    ExpenseService expenseService;

    @GetMapping("/getAllExpenses")
    public List<Expense> getExpenses(){
        return expenseService.getExpenses();
    }

    @PostMapping("/addExpense")
    public ResponseEntity<Expense> addExpense(@RequestBody Expense expense) throws URISyntaxException {
        Expense result = expenseService.addExpense(expense);
        return ResponseEntity.created(new URI("/expenses/addExpense" + result.getId())).body(result);
    }

    @DeleteMapping("removeExpense/{id}")
    public ResponseEntity<?> deleteExpense(@PathVariable("id") Long id){
        expenseService.removeExpense(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/searchByName")
    public List<Expense> searchByName(@RequestBody String name){
        return expenseService.searchByName(name);
    }

    @GetMapping("/searchByCategory")
    public List<Expense> searchByCategory(@RequestBody String categoryName){
        return expenseService.searchByCategory(categoryName);
    }

    @GetMapping("/searchByDate")
    public List<Expense> searchByDate(@RequestBody Instant date){
        return expenseService.searchByDate(date);
    }

}
