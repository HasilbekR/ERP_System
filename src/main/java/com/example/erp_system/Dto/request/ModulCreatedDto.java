package com.example.erp_system.Dto.request;

import com.example.erp_system.entity.LessonEntity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ModulCreatedDto {
    private Integer moduleNumber;

    private List<LessonEntity> lessons;
}
