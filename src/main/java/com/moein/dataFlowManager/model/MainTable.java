package com.moein.dataFlowManager.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.envers.Audited;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.util.List;
import java.util.Map;

@Entity
@Audited
@Getter
@Setter
public class MainTable extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "object_id", nullable = false)
    private ObjectDocument object;

    @NotNull
    private Integer numberOfStart;

    @ElementCollection
    @CollectionTable(name = "main_table_translations", joinColumns = @JoinColumn(name = "main_table_id"))
    @MapKeyColumn(name = "locale")
    @Column(name = "translation")
    private Map<String, String> translate;

    @ElementCollection
    @CollectionTable(name = "calculation_methods", joinColumns = @JoinColumn(name = "main_table_id"))
    @Column(name = "method")
    private List<String> calculationMethod;

    @Enumerated(EnumType.STRING)
    private RecordType typeOfRecord;

    @ElementCollection
    @CollectionTable(name = "main_table_descriptions", joinColumns = @JoinColumn(name = "main_table_id"))
    @MapKeyColumn(name = "locale")
    @Column(name = "description")
    private Map<String, String> description;

    private boolean hidden;
}
