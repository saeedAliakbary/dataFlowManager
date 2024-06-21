package com.moein.dataFlowManager.service;

import com.moein.dataFlowManager.model.ObjectDocument;
import com.moein.dataFlowManager.repository.ObjectDocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ObjectDocumentService {

    @Autowired
    private ObjectDocumentRepository objectDocumentRepository;

    @Transactional(readOnly = true)
    public Page<Object> findAll(int page, int size, String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return objectDocumentRepository.findAll(pageable);
    }

    @Transactional(readOnly = true)
    public Optional<Object> findById(Long id) {
        return objectDocumentRepository.findById(id);
    }

    @Transactional
    public ObjectDocument save(ObjectDocument objectDocument) {
        return objectDocumentRepository.save(objectDocument);
    }

    @Transactional
    public void deleteById(Long id) {
        objectDocumentRepository.deleteById(id);
    }
}
