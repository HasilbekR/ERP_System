package com.example.erp_system.repository;

import com.example.erp_system.entity.UserEntity;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface GroupRepository {
    @Query(value = "select s.students from groups s where s.id = :groupId")
    List<UserEntity> getGroupStudent(UUID groupId);
}
