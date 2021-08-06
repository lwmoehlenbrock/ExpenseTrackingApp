package com.example.reacttutorial.expensetracker.repositories;

import com.example.reacttutorial.expensetracker.model.Category;
import com.example.reacttutorial.expensetracker.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.Date;
import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    public List<Expense> findByDescription(String name);
    public List<Expense> findByCategory(Category category);
    public List<Expense> findByDate(Instant date);
}
