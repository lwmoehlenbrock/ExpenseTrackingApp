package com.example.reacttutorial.expensetracker.model;

import javax.persistence.*;
import java.time.Instant;
import java.util.Date;

@Entity
@Table(name="expense")
public class Expense {

    @Id
    @GeneratedValue
    private Long id;

    private Instant date;

    private String description;

    @ManyToOne
    private Category category;

    private double amount;



    public Long getId() {
        return id;
    }

    public Instant getDate() {
        return date;
    }

    public void setDate(Instant date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "id=" + id +
                ", date=" + date +
                ", description='" + description + '\'' +
                ", category=" + category +
                ", amount=" + amount +
                '}';
    }
}
