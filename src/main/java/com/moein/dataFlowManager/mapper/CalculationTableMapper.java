package com.moein.dataFlowManager.mapper;

import com.moein.dataFlowManager.dto.CalculationTableDTO;
import com.moein.dataFlowManager.model.CalculationTable;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CalculationTableMapper {
    CalculationTableMapper INSTANCE = Mappers.getMapper(CalculationTableMapper.class);

    CalculationTableDTO toDto(CalculationTable calculationTable);
    CalculationTable toEntity(CalculationTableDTO calculationTableDTO);
}
