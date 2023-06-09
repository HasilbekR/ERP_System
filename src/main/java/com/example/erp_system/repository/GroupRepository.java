package com.example.erp_system.repository;

import com.example.erp_system.entity.BaseEntity;
import com.example.erp_system.entity.GroupEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.UUID;

@Repository
public interface GroupRepository extends JpaRepository<GroupEntity , UUID>{

    GroupEntity findGroupEntityById(UUID id);

    List<GroupEntity> searchGroupEntitiesByNameContainingIgnoreCase(String name, Pageable page);


}
