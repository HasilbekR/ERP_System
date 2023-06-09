package com.example.erp_system.repository.user;

import com.example.erp_system.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, UUID> {

    Optional<UserEntity> findUserEntityByPhoneNumber(String phoneNumber);
    @Query(value = "select a from archive a order by a.archivedDate asc ")
    List<UserEntity> archivedStudents();


}
