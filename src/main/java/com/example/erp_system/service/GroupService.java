package com.example.erp_system.service;

import com.example.erp_system.dto.GroupCreateDto;
import com.example.erp_system.entity.GroupEntity;
import com.example.erp_system.entity.UserEntity;
import com.example.erp_system.exceptions.GroupNotFoundException;
import com.example.erp_system.repository.GroupRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GroupService  {

    private final GroupRepository groupRepository;
    private final ModelMapper modelMapper;



    public GroupEntity save(GroupCreateDto groupCreateDto) {
        GroupEntity group = modelMapper.map(groupCreateDto, GroupEntity.class);
        return groupRepository.save(group);
    }


    public GroupEntity update(GroupCreateDto groupCreateDto, UUID id) {
        GroupEntity group = groupRepository.findById(id).
                orElseThrow( () -> new GroupNotFoundException("group not found"));
        modelMapper.map(groupCreateDto,group);
        return groupRepository.save(group);
    }

    public void deleteById(UUID id) {
        groupRepository.deleteById(id);
    }

    public GroupEntity getById(UUID id) {
      return groupRepository.findGroupEntityById(id);
    }


}
