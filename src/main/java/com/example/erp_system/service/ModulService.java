package com.example.erp_system.service;



import com.example.erp_system.Dto.request.ModuleCreatedDto;
import com.example.erp_system.entity.LessonEntity;
import com.example.erp_system.entity.ModuleEntity;
import com.example.erp_system.repository.ModuleRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.modelmapper.config.Configuration;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ModulService {

    private final ModuleRepository moduleRepository;
    private final ModelMapper modelMapper;
    public ModuleEntity save(ModuleCreatedDto moduleCreateDro) {
        ModuleEntity moduleEntity = modelMapper.map(moduleCreateDro, ModuleEntity.class);
        List<LessonEntity> lessons = moduleCreateDro.getLessons();
        modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);
        List<LessonEntity> lessonEntities = modelMapper.map(lessons, new TypeToken<List<LessonEntity>>() {
        }.getType());
        moduleEntity.setLessons(lessonEntities);
        return moduleRepository.save(moduleEntity);
    }
    public List<ModuleEntity> getALL(){
        return moduleRepository.findAll();
    }
    public ModuleEntity searchByModuleNumber(Integer moduleNumber){
        return moduleRepository.searchModuleEntitiesByModuleNumber(moduleNumber);
    }
    public void deleteByModuleNumber(Integer moduleNumber){
        moduleRepository.deleteByModuleNumber(moduleNumber);
    }

}
