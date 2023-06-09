package com.example.erp_system.service.user;

import com.example.erp_system.Dto.request.LoginDto;
import com.example.erp_system.Dto.request.UserRequestDto;
import com.example.erp_system.Dto.response.JwtResponse;
import com.example.erp_system.entity.UserEntity;
import com.example.erp_system.entity.UserRole;
import com.example.erp_system.exceptions.DataNotFoundException;
import com.example.erp_system.exceptions.IllegalAccessException;
import com.example.erp_system.exceptions.UnregisteredUserException;
import com.example.erp_system.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Override
    public UserEntity create(UserRequestDto request) {
        return userRepository.save(modelMapper.map(request, UserEntity.class));
    }

    @Override
    public JwtResponse login(LoginDto request) {
        Optional<UserEntity> user = userRepository.findUserEntityByNumber(request.getPhoneNumber());
        if(user.isEmpty())
            throw new UnregisteredUserException(
                    String.format("This %s phone number have not registered yet", request.getPhoneNumber())
            );
        else if(!user.get().getPassword().equals(request.getPassword()))
            throw new IllegalAccessException("wrong password");
        return JwtResponse.builder()
                .accessToken("1234")
                .build();
    }

    @Override
    public List<UserEntity>  getArchivedStudents(Principal principal) {
        UserEntity userEntity = userRepository.findUserEntityByPhoneNumber(principal.getName()).orElseThrow(
                () -> new DataNotFoundException("User not found")
        );
        List<UserRole> roles = userEntity.getRoles();
        for (UserRole role : roles){
            if(role == UserRole.ADMIN){
                return userRepository.archivedStudents();
            }
        }
        return null;
    }

    @Override
    public UserEntity getById(UUID id) {
        return userRepository.findById(id).orElseThrow(
                () -> new DataNotFoundException("not found"));
    }

    @Override
    public List<UserEntity> getAll() {
        return userRepository.findAll();
    }
}
