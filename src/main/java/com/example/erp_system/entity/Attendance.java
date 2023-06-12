package com.example.erp_system.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity(name = "attendance")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Attendance extends BaseEntity {
    private Boolean isActive;
    private String comment;


    @ManyToOne
    @JoinColumn(name = "studentId", referencedColumnName = "id")
    private UserEntity student;

    }
