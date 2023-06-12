package com.example.erp_system.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;
import java.util.Set;

@Entity(name = "groups")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class GroupEntity extends BaseEntity{
   @Column(unique = true)
    private String name;
    @OneToMany
    @JoinColumn(name = "studentId", referencedColumnName = "id")
    private List<UserEntity> students;
    @ManyToOne
    @JoinColumn(name = "mentorId", referencedColumnName = "id")
    private UserEntity mentor;
    private boolean isActive;
    @OneToMany
    private List<ModuleEntity> modules;
}
