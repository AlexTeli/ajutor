package com.licenta.licenta.dto;

import com.licenta.licenta.model.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegistrationDTO {
    private String username;
    private String email;
    private String password;
    private String confirmPassword;
    private Role role;
    private String teamName; // Only for TEAM_MANAGER role
}