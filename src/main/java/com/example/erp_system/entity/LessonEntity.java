package com.example.erp_system.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity(name = "lessons")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LessonEntity extends BaseEntity{
    private Integer lessonCount;
//    @OneToMany
//    private List<UserEntity> students;
}
