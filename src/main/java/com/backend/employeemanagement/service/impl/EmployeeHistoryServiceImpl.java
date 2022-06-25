package com.backend.employeemanagement.service.impl;

import com.backend.employeemanagement.constant.AttendanceAction;
import com.backend.employeemanagement.dto.EmployeeDto;
import com.backend.employeemanagement.dto.EmployeeHistoryDto;
import com.backend.employeemanagement.mapper.EmployeeHistoryMapper;
import com.backend.employeemanagement.mapper.EmployeeMapper;
import com.backend.employeemanagement.model.Employee;
import com.backend.employeemanagement.model.EmployeeHistory;
import com.backend.employeemanagement.repository.EmployeeHistoryRepository;
import com.backend.employeemanagement.service.EmployeeHistoryService;
import com.backend.employeemanagement.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Slf4j
public class EmployeeHistoryServiceImpl implements EmployeeHistoryService {

    @Autowired
    private EmployeeHistoryRepository employeeHistoryRepository;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmployeeHistoryMapper employeeHistoryMapper;

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public EmployeeHistoryDto addAttendance(Long employeeId, AttendanceAction action) {
        EmployeeDto employeeDto = employeeService.getEmployeeById(employeeId);
        Employee employee = employeeMapper.fromDto(employeeDto);
        EmployeeHistory employeeHistory = employeeHistoryRepository.save(EmployeeHistory.builder()
                .action(action)
                .dateTime(LocalDateTime.now())
                .employee(employee)
                .build());
        return employeeHistoryMapper.toDto(employeeHistory);
    }

}
