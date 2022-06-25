package com.backend.employeemanagement.service;

import com.backend.employeemanagement.constant.AttendanceAction;
import com.backend.employeemanagement.dto.EmployeeHistoryDto;

public interface EmployeeHistoryService {

    EmployeeHistoryDto addAttendance(Long employeeId, AttendanceAction action);

}
