package com.backend.employeemanagement.exception;

import com.backend.employeemanagement.dto.ErrorResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AppExceptionHandler {

    @ExceptionHandler(ServiceException.class)
    public ResponseEntity<ErrorResponseDto> handleServiceException(ServiceException ex){
        ErrorResponseDto errorResponseDto = ErrorResponseDto.builder()
                .code(ex.getCode())
                .message(ex.getMessage())
                .detailMessage(ex.getDetailMessage())
                .build();
        return new ResponseEntity<>(errorResponseDto, HttpStatus.valueOf(ex.getCode()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDto> handleException(Exception ex){
        ErrorResponseDto errorResponseDto = ErrorResponseDto.builder()
                .code(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .message(HttpStatus.INTERNAL_SERVER_ERROR.toString())
                .detailMessage(ex.getMessage())
                .build();
        return new ResponseEntity<>(errorResponseDto, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
