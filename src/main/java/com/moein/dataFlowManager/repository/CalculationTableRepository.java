package com.moein.dataFlowManager.repository;

import com.moein.dataFlowManager.model.CalculationTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalculationTableRepository extends JpaRepository<CalculationTable, Long> {
}
