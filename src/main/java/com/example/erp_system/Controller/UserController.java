package com.example.erp_system.Controller;

import com.example.erp_system.Dto.GroupCreateDto;
import com.example.erp_system.entity.GroupEntity;
import com.example.erp_system.entity.UserEntity;
import com.example.erp_system.service.GroupService;
import com.example.erp_system.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth/v1/user")
public class UserController {
    private final UserService userService;
    @PutMapping("/archived-students")
    @PreAuthorize(value = "hasRole('ADMIN')")
    public ResponseEntity<List<UserEntity>> archivedStudents(
            Principal principal) {
        return ResponseEntity.ok(userService.getArchivedStudents(principal));
    }


}
