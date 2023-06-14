package com.example.erp_system.Controller;

import com.example.erp_system.Dto.request.GroupCreateDto;
import com.example.erp_system.entity.GroupEntity;
import com.example.erp_system.entity.UserEntity;
import com.example.erp_system.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/group")
public class GroupController {

    private final GroupService groupService;

  @PostMapping("/add")
  @PreAuthorize("hasRole(ADMIN)")
  public ResponseEntity<GroupEntity> addGroup(
         @RequestBody GroupCreateDto groupDto
         ){

      return ResponseEntity.ok(groupService.save(groupDto));
  }


  @DeleteMapping("/{groupId}/delete")
  @PreAuthorize("hasRole(ADMIN)")
  public ResponseEntity deleteGroup(
            @PathVariable UUID groupId
  ){
      groupService.deleteById(groupId);
      return ResponseEntity.status(204).build();
  }



    @PatchMapping("/{groupId}/update")
    @PreAuthorize("hasRole(ADMIN)")

    public ResponseEntity<GroupEntity> updateGroup(
            @PathVariable UUID groupId,
            @RequestBody GroupCreateDto groupCreateDto
    ){
        return ResponseEntity.ok(groupService.update(groupCreateDto, groupId));
    }

    @GetMapping("/{groupId}/getGroup")
    @PreAuthorize("hasRole(ADMIN)")

    public ResponseEntity<GroupEntity> getGroup(
            @PathVariable UUID groupId
    ){
        return ResponseEntity.ok(groupService.findGroupEntityById(groupId));
    }

    @GetMapping("/getAll")
    @PreAuthorize("hasRole(ADMIN)")

    public ResponseEntity<List<GroupEntity>> getAll(
            @RequestParam(required = false) int page,
            @RequestParam(required = false) int size
    ){
        return ResponseEntity.status(200).body(groupService.getAll(page,size));
    }



    @GetMapping("/search")
    @PreAuthorize("hasRole(ADMIN)")

    public ResponseEntity<List<GroupEntity>> searchBookByName(
            @RequestParam int page,
            @RequestParam int size,
            @RequestParam String name
    ){
        return ResponseEntity.status(200).body(groupService.searchBook(name, page, size));
    }

    @DeleteMapping("/{groupId}/{studentId}/delete")
    public ResponseEntity deleteStudentFromGroup(
            @PathVariable UUID groupId,
            @PathVariable UUID studentId
            ){
      groupService.deleteStudentById(groupId,studentId);
      return ResponseEntity.status(202).build();
    }

    @PostMapping("/{groupId}/{studentId}/addStudent")
    public ResponseEntity<GroupEntity> addStudentToGroup(
            @PathVariable UUID groupId,
            @PathVariable UUID studentId
    ){
      return ResponseEntity.ok(groupService.addStudentToGroup(groupId,studentId));
    }


}
