package com.example.erp_system.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;

@Entity(name = "modules")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ModuleEntity extends BaseEntity{
    private Integer moduleNumber;
    @OneToMany
    private List<LessonEntity> lessons;
}
