package com.moein.dataFlowManager.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CalculationTableDTO {
    private Long id;
    private int number;
    private String command;
    private String description;
    private boolean hidden;
}
