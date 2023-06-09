package com.example.erp_system.Dto.request;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserRequestDto {
    private String fullName;
    private String phoneNumber;
    private String password;
}
