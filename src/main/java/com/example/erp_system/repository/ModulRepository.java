package com.example.erp_system.repository;

import com.example.erp_system.entity.ModuleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

public interface ModulRepository extends JpaRepository<ModuleEntity, UUID> {
  ModuleEntity searchModuleEntitiesByModuleNumber(Integer modulNumber);
  void deleteByModuleNumber(Integer modulNumber);
}
