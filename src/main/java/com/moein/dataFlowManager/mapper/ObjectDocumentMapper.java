package com.moein.dataFlowManager.mapper;

import com.moein.dataFlowManager.dto.ObjectDocumentDTO;
import com.moein.dataFlowManager.model.ObjectDocument;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ObjectDocumentMapper {
    ObjectDocumentMapper INSTANCE = Mappers.getMapper(ObjectDocumentMapper.class);

    ObjectDocumentDTO toDto(ObjectDocument objectDocument);
    ObjectDocument toEntity(ObjectDocumentDTO objectDocumentDTO);
}
