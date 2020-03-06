package com.jchips12.profile.presentation.dto;

import com.jchips12.profile.application.constant.ExecutionStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class RegistrationResponse {

    private String messageId;
    private ExecutionStatus result;
    private String message;

}
