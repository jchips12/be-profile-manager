package com.jchips12.profile.presentation.rest;

import com.jchips12.profile.application.constant.ExecutionStatus;
import com.jchips12.profile.application.entity.AppUser;
import com.jchips12.profile.application.service.RegistrationService;
import com.jchips12.profile.presentation.dto.RegistrationRequest;
import com.jchips12.profile.presentation.dto.RegistrationResponse;
import lombok.RequiredArgsConstructor;
import org.slf4j.MDC;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/api")
public class RegistrationController {

    private final RegistrationService registrationService;

    @PostMapping("/register")
    ResponseEntity<RegistrationResponse> registerUser(@RequestBody RegistrationRequest registrationRequest) {
        registrationService.register(AppUser.builder()
                .firstName(registrationRequest.getFirstName())
                .lastName(registrationRequest.getLastName())
                .emailAddress(registrationRequest.getEmailAddress())
                .username(registrationRequest.getUsername())
                .password(registrationRequest.getPassword())
                .build());
        return ResponseEntity.ok(RegistrationResponse.builder()
                .messageId(MDC.get("messageId"))
                .result(ExecutionStatus.SUCCESS)
                .message("User created.")
                .build());
    }

}
