package com.backend.employeemanagement.dto;

import com.backend.employeemanagement.constant.EmployeeStatus;
import com.backend.employeemanagement.model.EmployeeHistory;
import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeDto {

    private Long id;

    @NotBlank(message = "name must not be blank")
    private String name;

    @Min(value = 1, message = "age must not be less than 1")
    private Integer age;

    @NotNull
    private LocalDate joiningDate;

    @NotNull
    private EmployeeStatus status;

    private List<EmployeeHistoryDto> history;

}
