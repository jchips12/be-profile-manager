package com.jchips12.profile.presentation.rest;

import com.jchips12.profile.presentation.dto.HelloResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@Slf4j
public class HelloController {

    @GetMapping(path = "/hello")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    ResponseEntity<HelloResponse> helloWorld(Principal principal) {
        return ResponseEntity.ok(HelloResponse.builder()
                .username(principal.getName())
                .message("Hello Wold")
                .build());
    }
}
