package com.example.erp_system.repository;

import com.example.erp_system.entity.ModuleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ModuleRepository extends JpaRepository<ModuleEntity, UUID> {

  ModuleEntity searchModuleEntitiesByModuleNumber(Integer moduleNumber);
  void deleteByModuleNumber(Integer moduleNumber);
}
