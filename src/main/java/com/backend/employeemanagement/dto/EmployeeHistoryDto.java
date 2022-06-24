package com.backend.employeemanagement.dto;

import com.backend.employeemanagement.constant.AttendanceAction;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeHistoryDto {

    private Long id;

    private AttendanceAction action;

    private LocalDateTime dateTime;

    private Long employeeId;

}
