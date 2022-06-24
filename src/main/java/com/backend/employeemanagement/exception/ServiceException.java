package com.backend.employeemanagement.exception;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ServiceException extends RuntimeException {

    private Integer code;
    private String message;
    private String detailMessage;

}
