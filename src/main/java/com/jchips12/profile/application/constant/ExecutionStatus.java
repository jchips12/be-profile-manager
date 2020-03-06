package com.jchips12.profile.application.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ExecutionStatus {

    SUCCESS, FAIL, PENDING, NEW;

}
