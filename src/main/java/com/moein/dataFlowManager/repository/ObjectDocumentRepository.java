package com.moein.dataFlowManager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ObjectDocumentRepository extends JpaRepository<Object, Long> {
}
