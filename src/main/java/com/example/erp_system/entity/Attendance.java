package com.example.erp_system.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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


    @OneToOne
    private UserEntity student;

}
