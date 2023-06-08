package com.example.erp_system.repository;

import com.example.erp_system.entity.GroupEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.UUID;

@Repository
public interface GroupRepository extends JpaRepository<GroupEntity , UUID>{

    GroupEntity findGroupEntityById(UUID id);

}
