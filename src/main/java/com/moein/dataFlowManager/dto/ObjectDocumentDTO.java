package com.moein.dataFlowManager.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ObjectDocumentDTO {
    private Long id;
    private String name;
    private List<MainTableDTO> mainTables;
    private CalculationTableDTO calculationTable;
    private String description;
}
