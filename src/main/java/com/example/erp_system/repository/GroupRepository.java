package com.example.erp_system.repository;
import com.example.erp_system.Dto.request.UserRequestDto;
import com.example.erp_system.entity.GroupEntity;
import com.example.erp_system.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.erp_system.entity.BaseEntity;
import com.example.erp_system.entity.GroupEntity;
import org.springframework.data.domain.Pageable;


import java.util.List;
import java.util.UUID;

@Repository
public interface GroupRepository extends JpaRepository<GroupEntity , UUID>{
    GroupEntity findGroupEntityById(UUID id);
    @Query(value = "insert into groups_students(groups_id, students_id) values(:groups_id,:students_id)", nativeQuery = true)
    GroupEntity addStudentToGroup(UUID groups_id,UUID students_id);

    @Query(value = "delete from groups_students where groups_id = ?1 and students_id = ?2", nativeQuery = true)
    void deleteStudentById(UUID groupId, UUID studentId);
 List<GroupEntity> searchGroupEntitiesByNameContainingIgnoreCase(String name, Pageable page);
}