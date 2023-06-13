package com.example.erp_system.service.user;

import com.example.erp_system.Dto.request.LoginDto;
import com.example.erp_system.Dto.request.UserRequestDto;
import com.example.erp_system.Dto.response.JwtResponse;
import com.example.erp_system.entity.UserEntity;
import com.example.erp_system.entity.UserRole;
import com.example.erp_system.exceptions.AuthenticationFailedException;
import com.example.erp_system.exceptions.DataNotFoundException;
import com.example.erp_system.exceptions.IllegalAccessException;
import com.example.erp_system.exceptions.UnregisteredUserException;
import com.example.erp_system.repository.user.UserRepository;
import com.example.erp_system.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
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
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    @Override
    public UserEntity create(UserRequestDto request) {
        UserEntity userentity = modelMapper.map(request, UserEntity.class);
        userentity.setPassword(passwordEncoder.encode(userentity.getPassword()));
        userentity.setRoles(List.of(UserRole.USER));
        return userRepository.save(userentity);

    }

    public JwtResponse signIn(String username, String password)  {
        UserEntity userEntitiesByUsername = userRepository.findUserEntityByUsername(username)
                .orElseThrow(() -> new AuthenticationFailedException("incorrect username or password"));
        String accessToken = jwtService.generateAccessToken(userEntitiesByUsername);
        if (userEntitiesByUsername.getPassword().equals(password)){
            return JwtResponse.builder().accessToken(accessToken).build();
        }
        throw new AuthenticationFailedException("Invalid username or password");
    }


    @Override
    public JwtResponse login(LoginDto loginDto) {

        UserEntity userEntity = userRepository.findUserEntityByPhoneNumber(loginDto.getPhoneNumber()).orElseThrow(
                () -> new DataNotFoundException("User nor found!")
        );
        if(passwordEncoder.matches(loginDto.getPassword(),userEntity.getPassword())){
            String s = jwtService.generateAccessToken(userEntity);
            return JwtResponse.builder().accessToken(s).build();
        }
        throw new DataNotFoundException("User not found");
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
        return userRepository.findUserEntityById(id).orElseThrow(
                () -> new DataNotFoundException("user not found"));
    }

    @Override
    public List<UserEntity> getAll() {
        return userRepository.findAll();
    }
}
