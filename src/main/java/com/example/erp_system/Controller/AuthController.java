package com.example.erp_system.Controller;

import com.example.erp_system.Dto.response.JwtResponse;
import com.example.erp_system.Dto.request.LoginDto;
import com.example.erp_system.Dto.request.UserRequestDto;
import com.example.erp_system.entity.UserEntity;
import com.example.erp_system.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth/")
public class AuthController {

    private final UserService userService;

    @GetMapping("/signIn")
    public ResponseEntity<JwtResponse> signIn(
            @RequestBody LoginDto loginDto
    ){
         return ResponseEntity.ok(userService.login(loginDto));
    }

    @PostMapping("/signUp")
    public ResponseEntity<UserEntity> signUp(
            @RequestBody UserRequestDto userRequestDto
    ){
        return ResponseEntity.ok(userService.create(userRequestDto));
    }
}
