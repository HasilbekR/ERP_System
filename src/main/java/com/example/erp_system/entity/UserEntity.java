package com.example.erp_system.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Entity(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UserEntity extends BaseEntity {
    @Column(unique = true,nullable = false)
    private String fullName;
    private String number;
    @Column(nullable = false)
    private String password;
    @Enumerated(EnumType.STRING)
    private List<UserRole> roles;
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//         String ROLE = "ROLE_";
//         List<SimpleGrantedAuthority> authorities = new ArrayList<>();
//         for (UserRole role : roles){
//             authorities.add(new SimpleGrantedAuthority(ROLE + role.name()));
//         }
//         return authorities;
//    }
//
//
//    @Override
//    public String getPassword() {
//        return password;
//    }
//
//    @Override
//    public String getUsername() {
//        return number;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return false;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return false;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return false;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return false;
//    }
}
