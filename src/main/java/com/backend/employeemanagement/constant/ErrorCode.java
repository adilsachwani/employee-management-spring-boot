package com.backend.employeemanagement.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    EMPLOYEE_NOT_FOUND(404, "Employee not found", "Employee not found with id %s");

    private final Integer code;
    private final String message;
    private final String detailMessage;

}
