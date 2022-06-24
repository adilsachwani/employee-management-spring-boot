package com.backend.employeemanagement.dto;

import com.backend.employeemanagement.constant.EmployeeStatus;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeDto {

    private Long id;

    private String name;

    private Integer age;

    private LocalDate joiningDate;

    private EmployeeStatus status;

}
