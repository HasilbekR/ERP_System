package com.example.erp_system.repository;
import com.example.erp_system.Dto.request.UserRequestDto;
import com.example.erp_system.entity.GroupEntity;
import com.example.erp_system.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;


import java.util.List;
import java.util.UUID;

@Repository
public interface GroupRepository extends JpaRepository<GroupEntity , UUID>{
    GroupEntity findGroupEntityById(UUID id);


    @Query(value = "INSERT INTO groups_students(groupsId, studentsId) " +
            "values (:groupsId, :studentsId)", nativeQuery = true)
   GroupEntity addStudentToGroup(UUID groupsId, UUID studentsId);

    @Query(value = "delete from groups_students where groups.students.id = :studentsId and groups.id = :groupsId", nativeQuery = true)
    UserEntity deleteStudentFromGroup(UUID groupsId, UUID studentsId);

 List<GroupEntity> searchGroupEntitiesByNameContainingIgnoreCase(String name, Pageable page);
}