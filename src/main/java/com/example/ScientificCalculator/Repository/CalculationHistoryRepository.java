package com.example.ScientificCalculator.Repository;

import com.example.ScientificCalculator.Entity.CalculationHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalculationHistoryRepository extends JpaRepository<CalculationHistory, Long> {
    long count();
    void deleteById(Long id);
}
