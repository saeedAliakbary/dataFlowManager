package com.moein.dataFlowManager.controller;

import com.moein.dataFlowManager.dto.CalculationTableDTO;
import com.moein.dataFlowManager.service.CalculationTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/calculationtables")
@Validated
public class CalculationTableController {

    @Autowired
    private CalculationTableService calculationTableService;

    @GetMapping("/{id}")
    public ResponseEntity<CalculationTableDTO> getCalculationTable(@PathVariable Long id) {
        return calculationTableService.findById(id)
                .map(calculationTableDTO -> new ResponseEntity<>(calculationTableDTO, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<CalculationTableDTO> createCalculationTable(@RequestBody @Valid CalculationTableDTO calculationTableDTO) {
        CalculationTableDTO savedCalculationTableDTO = calculationTableService.save(calculationTableDTO);
        return new ResponseEntity<>(savedCalculationTableDTO, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CalculationTableDTO> updateCalculationTable(@PathVariable Long id, @RequestBody @Valid CalculationTableDTO calculationTableDTO) {
        if (!calculationTableService.findById(id).isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        calculationTableDTO.setId(id);
        CalculationTableDTO updatedCalculationTableDTO = calculationTableService.save(calculationTableDTO);
        return new ResponseEntity<>(updatedCalculationTableDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCalculationTable(@PathVariable Long id) {
        if (!calculationTableService.findById(id).isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        calculationTableService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
