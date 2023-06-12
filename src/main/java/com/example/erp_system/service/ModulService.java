package com.example.erp_system.service;

import com.example.erp_system.Dto.LessonRequestDto;
import com.example.erp_system.Dto.ModelCreateDto;

import com.example.erp_system.entity.LessonEntity;
import com.example.erp_system.entity.ModuleEntity;
import com.example.erp_system.repository.ModulRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.modelmapper.config.Configuration;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ModulService {
    private final ModulRepository modulRepository;
    private final ModelMapper modelMapper;
    public ModuleEntity save(ModelCreateDto modelCreateDto) {
        ModuleEntity modulEntity = modelMapper.map(modelCreateDto, ModuleEntity.class);
        List<LessonRequestDto> lessons = modelCreateDto.getLessons();
        modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);
        List<LessonEntity> lessonEntities = modelMapper.map(lessons, new TypeToken<List<LessonEntity>>() {
        }.getType());
        modulEntity.setLessons(lessonEntities);
        return modulRepository.save(modulEntity);
    }
    public List<ModuleEntity> getALL(){
        return modulRepository.findAll();
    }
    public ModuleEntity searchByModulNumber(Integer modulNumber){
        return modulRepository.searchModuleEntitiesByModuleNumber(modulNumber);
    }
    public void deleteByModulNumber(Integer modulNumber){
        modulRepository.deleteByModuleNumber(modulNumber);
    }

}
