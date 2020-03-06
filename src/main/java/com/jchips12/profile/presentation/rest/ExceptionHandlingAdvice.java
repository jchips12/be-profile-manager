package com.jchips12.profile.presentation.rest;

import com.jchips12.profile.application.constant.ExecutionStatus;
import com.jchips12.profile.application.exception.UserNameAlreadyInUseException;
import com.jchips12.profile.presentation.dto.RegistrationResponse;
import org.slf4j.MDC;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlingAdvice {

    @ExceptionHandler(value = UserNameAlreadyInUseException.class)
    ResponseEntity<RegistrationResponse> userNameAlreadyInUse(RuntimeException ex) {
        return ResponseEntity.badRequest().body(RegistrationResponse.builder()
                .messageId(MDC.get("messageId"))
                .result(ExecutionStatus.FAIL)
                .message(ex.getMessage())
                .build());
    }
}
