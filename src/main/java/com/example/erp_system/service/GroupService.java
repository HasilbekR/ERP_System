package com.example.erp_system.service;
import com.example.erp_system.Dto.request.GroupCreateDto;
import com.example.erp_system.Dto.request.UserRequestDto;
import com.example.erp_system.entity.GroupEntity;
import com.example.erp_system.entity.UserEntity;
import com.example.erp_system.entity.ModuleEntity;
import com.example.erp_system.exceptions.DataNotFoundException;
import com.example.erp_system.exceptions.GroupNotFoundException;
import com.example.erp_system.repository.GroupRepository;
import com.example.erp_system.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GroupService  {

    private final GroupRepository groupRepository;
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;

    public GroupEntity save(GroupCreateDto groupCreateDto) {
        List<String> studentPhoneNumber = groupCreateDto.getStudentPhoneNumber();
        List<UserEntity> students = null;
        for (String student : studentPhoneNumber) {
            students.add(userRepository.findUserEntityByNumber(student).orElseThrow(
                    () -> new DataNotFoundException("User not found")
            ));
        }
        UserEntity mentor = userRepository.findUserEntityByNumber(groupCreateDto.getMentorPhoneNumber()).orElseThrow(
                () -> new DataNotFoundException("User not found"));

        ModuleEntity module = ModuleEntity.builder()
                .moduleNumber(groupCreateDto.getModuleNumber())
                 .build();
        GroupEntity group = GroupEntity.builder()
                .isActive(groupCreateDto.isActive())
                .mentor(mentor)
                .name(groupCreateDto.getName())
                .students(students)
                .build();
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

    public GroupEntity findGroupEntityById(UUID id) {
      return groupRepository.findGroupEntityById(id);
    }
 
    public List<GroupEntity> getAll(int page, int size){
        Pageable pageable = PageRequest.of(page,size);
        return groupRepository.findAll(pageable).getContent();
    }

    //UserCreateDto newStudentni UUID student id ga ozgartirganimni sababi
    //Chunki tayyor user bolib royhatan otgan userga student rolini berib
    //Id si bilan qoshib qoyadiku biz yengi sozdata qilyab miz ,fikr va takliflar uchun
    //muraojaat tg kanal
    public GroupEntity addStudentToGroup(UUID attendanceId ,UUID studentId){
        GroupEntity group = modelMapper.map(studentId,GroupEntity.class);
        return groupRepository.addStudentToAttendance(attendanceId, studentId);
    }

    public GroupEntity deleteStudentById(UUID attendance, UUID studentId){
       return groupRepository.deleteStudentById(attendance, studentId);
    }

    public List<GroupEntity> searchBook(String name, int page, int size) {
        Sort sort = Sort.by(Sort.Direction.ASC, "name");
        Pageable pageable = PageRequest.of(page, size, sort);
        return groupRepository.searchGroupEntitiesByNameContainingIgnoreCase(name, pageable);
    }
}
