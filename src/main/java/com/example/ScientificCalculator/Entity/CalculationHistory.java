package com.example.ScientificCalculator.Entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class CalculationHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String calculation;
    private String result;
    private LocalDateTime timestamp;

    public CalculationHistory() {}

    public CalculationHistory(String calculation, String result) {
        this.calculation = calculation;
        this.result = result;
        this.timestamp = LocalDateTime.now();
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCalculation() {
        return calculation;
    }

    public void setCalculation(String calculation) {
        this.calculation = calculation;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
