package com.example.ScientificCalculator.Services;

import com.example.ScientificCalculator.Entity.CalculationHistory;

import com.example.ScientificCalculator.Repository.CalculationHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalculationHistoryService {

    @Autowired
    private CalculationHistoryRepository repository;

    private static final int HISTORY_LIMIT = 50;

    public void addCalculation(String calculation, String result) {
        if (repository.count() >= HISTORY_LIMIT) {
            Long oldestId = repository.findAll().get(0).getId();
            repository.deleteById(oldestId);
        }
        CalculationHistory history = new CalculationHistory(calculation, result);
        repository.save(history);
    }

    public List<CalculationHistory> getAllHistory() {
        return repository.findAll();
    }
}
