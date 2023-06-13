package com.example.erp_system.service;

import com.example.erp_system.entity.Attendance;
import com.example.erp_system.entity.LessonEntity;
import com.example.erp_system.entity.UserEntity;
import com.example.erp_system.repository.GroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class LessonService {
   private final GroupRepository groupRepository;


   public LessonEntity createLesson(UUID groupId) {
      LessonEntity lesson = LessonEntity.builder()
              .lessonCount(1)
              .attendance((List<Attendance>) Attendance.builder()
                      .comment(null)
                      .isActive(false)
                      .student((UserEntity) groupRepository.getGroupStudent(groupId)).build())
              .build();
      return lesson;
   }
}
