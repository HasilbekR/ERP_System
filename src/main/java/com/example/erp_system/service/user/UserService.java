package com.example.erp_system.service.user;

import com.example.erp_system.Dto.request.LoginDto;
import com.example.erp_system.Dto.request.UserRequestDto;
import com.example.erp_system.Dto.response.JwtResponse;
import com.example.erp_system.entity.UserEntity;
import com.example.erp_system.service.BaseService;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;

@Service
public interface UserService extends BaseService<UserEntity, UserRequestDto> {
    JwtResponse login(LoginDto request);
    List<UserEntity> getArchivedStudents(Principal principal);
}
