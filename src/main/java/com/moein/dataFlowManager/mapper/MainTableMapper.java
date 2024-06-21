package com.moein.dataFlowManager.mapper;

import com.moein.dataFlowManager.dto.MainTableDTO;
import com.moein.dataFlowManager.model.MainTable;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MainTableMapper {
    MainTableMapper INSTANCE = Mappers.getMapper(MainTableMapper.class);

    MainTableDTO toDto(MainTable mainTable);
    MainTable toEntity(MainTableDTO mainTableDTO);
}
