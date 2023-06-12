package com.example.erp_system.service;

import com.example.erp_system.exceptions.DataNotFoundException;
import com.example.erp_system.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return  userRepository.findUserEntityByUsername(username)
                .orElseThrow(
                        () -> new DataNotFoundException("User not found")
                );
    }
}
