package com.example.erp_system.entity;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

import java.util.Set;

public class ModuleEntity extends BaseEntity{
    private Integer moduleNumber;
    @OneToMany
    private Set<LessonEntity> lessons;
}
