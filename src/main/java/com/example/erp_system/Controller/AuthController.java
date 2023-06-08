package com.example.erp_system.Controller;

import com.example.erp_system.Dto.JwtResponse;
import com.example.erp_system.Dto.LoginDto;
import com.example.erp_system.Dto.UserRequestDto;
import com.example.erp_system.Service.AuthService;
import com.example.erp_system.entity.UserEntity;
import com.example.erp_system.entity.UserRole;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth/")
public class AuthController {

    private final AuthService authService;
    private final UserEntity userEntity;

    @GetMapping("/signIn")
    public ResponseEntity<JwtResponse> signIn(
            @RequestBody LoginDto loginDto

    ){
        if(userEntity.getRoles().contains(UserRole.MENTOR)){
            return ResponseEntity.ok(authService.signIn(loginDto));
        }
        if(userEntity.getRoles().contains(UserRole.ADMIN)){
            return ResponseEntity.ok(authService.signIn(loginDto));
        }
        return ResponseEntity.ok(authService.signIn(loginDto));
    }

    @PostMapping("/signUp")
    public ResponseEntity<UserEntity> signUp(
            @RequestBody UserRequestDto userRequestDto
    ){
        return ResponseEntity.ok((UserEntity) authService.save(userRequestDto, List.of(UserRole.USER)));
    }
}
