package com.example.erp_system.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GroupCreateDto {
    private String name;
    private List<String> studentList;
    private String mentor;
    private boolean isActive;
    private Integer module;
}
