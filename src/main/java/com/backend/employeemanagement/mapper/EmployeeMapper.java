package com.backend.employeemanagement.mapper;

import com.backend.employeemanagement.dto.EmployeeDto;
import com.backend.employeemanagement.model.Employee;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    EmployeeDto toDto(Employee employee);

    List<EmployeeDto> toListDto(List<Employee> employees);

    Employee fromDto(EmployeeDto employeeDto);

}
