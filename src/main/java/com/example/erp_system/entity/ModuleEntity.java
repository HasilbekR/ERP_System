package com.example.erp_system.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity(name = "modules")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ModuleEntity extends BaseEntity{
    private Integer moduleNumber;
    @OneToMany
    private Set<LessonEntity> lessons;
}
