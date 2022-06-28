package com.backend.employeemanagement.mapper;

import com.backend.employeemanagement.dto.EmployeeHistoryDto;
import com.backend.employeemanagement.model.EmployeeHistory;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmployeeHistoryMapper {

    @Mapping(source = "employee.id", target = "employeeId")
    EmployeeHistoryDto toDto(EmployeeHistory employeeHistory);

    List<EmployeeHistoryDto> toListDto(List<EmployeeHistory> employeeHistories);

}
