package com.example.erp_system.repository;

import com.example.erp_system.Dto.request.UserRequestDto;
import com.example.erp_system.entity.GroupEntity;
import com.example.erp_system.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.UUID;

@Repository
public interface GroupRepository extends JpaRepository<GroupEntity , UUID>{
    GroupEntity findGroupEntityById(UUID id);

    GroupEntity addStudentToAttendance(UUID attendanceId, UserRequestDto newStudent);

    @Query("delete from attendance where users.roles = student and users.id = :id")
    UserEntity deleteStudentById(UUID attendance, UUID studentId);
}
