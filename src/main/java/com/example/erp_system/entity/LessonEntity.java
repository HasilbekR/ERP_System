package com.example.erp_system.entity;

import jakarta.persistence.Entity;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.*;

import java.util.List;


@Entity(name = "lessons")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class LessonEntity extends BaseEntity{
    private Integer lessonCount;
//    @OneToMany
//    private List<UserEntity> students;
@OneToMany
private List<Attendance> attendance;

