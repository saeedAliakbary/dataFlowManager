package com.moein.dataFlowManager.controller;

import com.moein.dataFlowManager.dto.MainTableDTO;
import com.moein.dataFlowManager.service.MainTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/maintables")
@Validated
public class MainTableController {

    @Autowired
    private MainTableService mainTableService;

    @GetMapping("/{id}")
    public ResponseEntity<MainTableDTO> getMainTable(@PathVariable Long id) {
        return mainTableService.findById(id)
                .map(mainTableDTO -> new ResponseEntity<>(mainTableDTO, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<MainTableDTO> createMainTable(@RequestBody @Valid MainTableDTO mainTableDTO) {
        MainTableDTO savedMainTableDTO = mainTableService.save(mainTableDTO);
        return new ResponseEntity<>(savedMainTableDTO, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MainTableDTO> updateMainTable(@PathVariable Long id, @RequestBody @Valid MainTableDTO mainTableDTO) {
        if (!mainTableService.findById(id).isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        mainTableDTO.setId(id);
        MainTableDTO updatedMainTableDTO = mainTableService.save(mainTableDTO);
        return new ResponseEntity<>(updatedMainTableDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMainTable(@PathVariable Long id) {
        if (!mainTableService.findById(id).isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        mainTableService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
