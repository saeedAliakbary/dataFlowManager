package com.moein.dataFlowManager.service;

import com.moein.dataFlowManager.dto.MainTableDTO;
import com.moein.dataFlowManager.mapper.MainTableMapper;
import com.moein.dataFlowManager.model.MainTable;
import com.moein.dataFlowManager.repository.MainTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MainTableService {

    @Autowired
    private MainTableRepository mainTableRepository;

    @Transactional(readOnly = true)
    public Optional<MainTableDTO> findById(Long id) {
        return mainTableRepository.findById(id)
                .map(MainTableMapper.INSTANCE::toDto);
    }

    @Transactional
    public MainTableDTO save(MainTableDTO mainTableDTO) {
        MainTable mainTable = MainTableMapper.INSTANCE.toEntity(mainTableDTO);
        MainTable savedMainTable = mainTableRepository.save(mainTable);
        return MainTableMapper.INSTANCE.toDto(savedMainTable);
    }

    @Transactional
    public void deleteById(Long id) {
        mainTableRepository.deleteById(id);
    }

    @Transactional
    public MainTableDTO hideById(Long id) {
        Optional<MainTable> optionalMainTable = mainTableRepository.findById(id);
        if (optionalMainTable.isPresent()) {
            MainTable mainTable = optionalMainTable.get();
            mainTable.setHidden(true);
            mainTableRepository.save(mainTable);
            return MainTableMapper.INSTANCE.toDto(mainTable);
        }
        throw new IllegalArgumentException("MainTable with id " + id + " not found.");
    }

    @Transactional
    public MainTableDTO unhideById(Long id) {
        Optional<MainTable> optionalMainTable = mainTableRepository.findById(id);
        if (optionalMainTable.isPresent()) {
            MainTable mainTable = optionalMainTable.get();
            mainTable.setHidden(false);
            mainTableRepository.save(mainTable);
            return MainTableMapper.INSTANCE.toDto(mainTable);
        }
        throw new IllegalArgumentException("MainTable with id " + id + " not found.");
    }

    @Transactional(readOnly = true)
    public List<MainTableDTO> findAllVisibleByObjectDocumentId(Long objectDocumentId) {
        List<MainTable> mainTables = mainTableRepository.findByObjectDocumentIdAndHiddenFalse(objectDocumentId);
        return mainTables.stream()
                .map(MainTableMapper.INSTANCE::toDto)
                .collect(Collectors.toList());
    }
}
