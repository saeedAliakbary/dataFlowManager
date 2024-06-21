package com.moein.dataFlowManager.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.envers.Audited;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Audited
@Getter
@Setter
public class CalculationTable extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "calculationTable")
    private ObjectDocument object;

    @NotNull
    private Integer number;

    @NotBlank
    private String command;

    private String description;

    private boolean hidden;
}
