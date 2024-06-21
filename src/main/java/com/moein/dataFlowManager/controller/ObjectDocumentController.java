package com.moein.dataFlowManager.controller;
import com.moein.dataFlowManager.model.ObjectDocument;
import com.moein.dataFlowManager.service.ObjectDocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;

@RestController
@RequestMapping("/api/objectdocuments")
@Validated
public class ObjectDocumentController {

    @Autowired
    private ObjectDocumentService objectDocumentService;

    @GetMapping
    public ResponseEntity<Page<Object>> listObjectDocuments(
            @RequestParam(defaultValue = "0") @Min(0) int page,
            @RequestParam(defaultValue = "10") @Min(1) int size,
            @RequestParam(defaultValue = "id") String sortBy) {
        Page<Object> result = objectDocumentService.findAll(page, size, sortBy);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ObjectDocument> createObjectDocument(@RequestBody @Valid ObjectDocument objectDocument) {
        ObjectDocument savedObjectDocument = objectDocumentService.save(objectDocument);
        return new ResponseEntity<>(savedObjectDocument, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getObjectDocument(@PathVariable Long id) {
        return objectDocumentService.findById(id)
                .map(objectDocument -> new ResponseEntity<>(objectDocument, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ObjectDocument> updateObjectDocument(@PathVariable Long id, @RequestBody @Valid ObjectDocument objectDocument) {
        if (!objectDocumentService.findById(id).isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        objectDocument.setId(id);
        ObjectDocument updatedObjectDocument = objectDocumentService.save(objectDocument);
        return new ResponseEntity<>(updatedObjectDocument, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteObjectDocument(@PathVariable Long id) {
        if (!objectDocumentService.findById(id).isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        objectDocumentService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

