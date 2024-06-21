package com.moein.dataFlowManager.service;

import com.moein.dataFlowManager.dto.CalculationTableDTO;
import com.moein.dataFlowManager.mapper.CalculationTableMapper;
import com.moein.dataFlowManager.model.CalculationTable;
import com.moein.dataFlowManager.repository.CalculationTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class CalculationTableService {

    @Autowired
    private CalculationTableRepository calculationTableRepository;

    @Transactional(readOnly = true)
    public Optional<CalculationTableDTO> findById(Long id) {
        return calculationTableRepository.findById(id)
                .map(CalculationTableMapper.INSTANCE::toDto);
    }

    @Transactional
    public CalculationTableDTO save(CalculationTableDTO calculationTableDTO) {
        CalculationTable calculationTable = CalculationTableMapper.INSTANCE.toEntity(calculationTableDTO);
        CalculationTable savedCalculationTable = calculationTableRepository.save(calculationTable);
        return CalculationTableMapper.INSTANCE.toDto(savedCalculationTable);
    }

    @Transactional
    public void deleteById(Long id) {
        calculationTableRepository.deleteById(id);
    }
}
