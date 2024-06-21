package com.moein.dataFlowManager.repository;

import com.moein.dataFlowManager.model.MainTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MainTableRepository extends JpaRepository<MainTable, Long> {
    List<MainTable> findByObjectDocumentIdAndHiddenFalse(Long objectDocumentId);
}