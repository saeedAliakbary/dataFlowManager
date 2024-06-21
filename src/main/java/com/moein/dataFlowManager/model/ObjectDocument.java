package com.moein.dataFlowManager.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.envers.Audited;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.util.List;

@Entity
@Audited
@Getter
@Setter
public class ObjectDocument extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 255)
    private String name;

    @OneToMany(mappedBy = "objectDocument", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MainTable> mainTables;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "calculation_table_id", referencedColumnName = "id")
    private CalculationTable calculationTable;

    private String description;
}
