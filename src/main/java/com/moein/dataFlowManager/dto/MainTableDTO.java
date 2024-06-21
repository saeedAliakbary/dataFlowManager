package com.moein.dataFlowManager.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MainTableDTO {
    private Long id;
    private int numberOfStart;
    private String translate;
    private List<String> calculationMethods;
    private String typeOfRecord;
    private String description;
    private boolean hidden;
}
