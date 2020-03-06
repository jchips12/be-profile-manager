package com.jchips12.profile.presentation.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class RegistrationRequest {

    private String firstName;
    private String lastName;
    private String emailAddress;
    private String username;
    private String password;

}
