package com.jchips12.profile.presentation.rest;

import com.jchips12.profile.presentation.dto.HelloResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class HelloController {

    @GetMapping(path = "/hello")
    ResponseEntity<HelloResponse> helloWorld(Principal principal) {
        return ResponseEntity.ok(HelloResponse.builder()
                .username(principal.getName())
                .message("Hello Wold")
                .build());
    }
}
