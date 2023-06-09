package com.example.erp_system.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity(name = "archive")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ArchivedStudents extends BaseEntity {
   @OneToOne
    private UserEntity user;
    private String groupName;

}
