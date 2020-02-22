package com.jchips12.profile.presentation.rest;

import com.jchips12.profile.application.entity.AppUser;
import com.jchips12.profile.presentation.dto.AppResponse;
import org.slf4j.MDC;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {

    @PostMapping("/register")
    ResponseEntity<AppResponse> registerUser(AppUser appUser) {
        return ResponseEntity.ok(AppResponse.builder().messageId(MDC.get("messageId")).build());
    }
}
