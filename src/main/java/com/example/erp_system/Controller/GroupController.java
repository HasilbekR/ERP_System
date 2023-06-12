package com.example.erp_system.Controller;

import com.example.erp_system.Dto.request.GroupCreateDto;
import com.example.erp_system.Dto.response.JwtResponse;
import com.example.erp_system.entity.GroupEntity;
import com.example.erp_system.exceptions.RequestValidationException;
import com.example.erp_system.service.GroupService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/group")
public class GroupController {

    private final GroupService groupService;

  @PostMapping("/add")
  //@PreAuthorize()
  public ResponseEntity<GroupEntity> addGroup(
         @RequestBody GroupCreateDto groupDto
         ){
      return ResponseEntity.ok(groupService.save(groupDto));
  }


  @DeleteMapping("/{groupId}/delete")
    public ResponseEntity deleteGroup(
            @PathVariable UUID groupId
  ){
      groupService.deleteById(groupId);
      return ResponseEntity.status(204).build();
  }

    @PatchMapping("/{groupId}update")
    public ResponseEntity<GroupEntity> updateGroup(
            @PathVariable UUID groupId,
            @RequestBody GroupCreateDto groupCreateDto
    ){
        return ResponseEntity.ok(groupService.update(groupCreateDto, groupId));
    }

    @GetMapping("/{groupId}getGroup")
    public ResponseEntity<GroupEntity> getGroup(
            @PathVariable UUID groupId
    ){
        return ResponseEntity.ok(groupService.findGroupEntityById(groupId));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<GroupEntity>> getAll(
            @RequestParam(required = false) int page,
            @RequestParam(required = false) int size
    ){
        return ResponseEntity.status(200).body(groupService.getAll(page,size));
    }



    @GetMapping("/search")
    public ResponseEntity<List<GroupEntity>> searchBookByName(
            @RequestParam int page,
            @RequestParam int size,
            @RequestParam String name
    ){
        return ResponseEntity.status(200).body(groupService.searchBook(name, page, size));
    }


}
