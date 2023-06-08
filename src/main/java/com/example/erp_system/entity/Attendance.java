package com.example.erp_system.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

import java.util.List;

@Entity(name = "attendance")
public class Attendance extends BaseEntity {
    private Boolean isActive;
    private String comment;


    @OneToMany
    @JoinColumn(name = "studentId", referencedColumnName = "id")
    private List<UserEntity> student;

    @OneToOne
    @JoinColumn(name = "lessonId", referencedColumnName = "id")
    private LessonEntity lesson;
}
