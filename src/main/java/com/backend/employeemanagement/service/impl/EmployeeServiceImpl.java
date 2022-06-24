package com.backend.employeemanagement.service.impl;

import com.backend.employeemanagement.dto.EmployeeDto;
import com.backend.employeemanagement.exception.ServiceException;
import com.backend.employeemanagement.mapper.EmployeeMapper;
import com.backend.employeemanagement.model.Employee;
import com.backend.employeemanagement.repository.EmployeeRepository;
import com.backend.employeemanagement.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.backend.employeemanagement.constant.ErrorCode.EMPLOYEE_NOT_FOUND;

@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employeeMapper.toListDto(employees);
    }

    @Override
    public EmployeeDto getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ServiceException(EMPLOYEE_NOT_FOUND.getCode(), EMPLOYEE_NOT_FOUND.getMessage(),
                        String.format(EMPLOYEE_NOT_FOUND.getDetailMessage(), id)));
        return employeeMapper.toDto(employee);
    }

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = employeeRepository.save(employeeMapper.fromDto(employeeDto));
        return employeeMapper.toDto(employee);
    }

    @Override
    public EmployeeDto updateEmployee(Long id, EmployeeDto employeeDto) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ServiceException(EMPLOYEE_NOT_FOUND.getCode(), EMPLOYEE_NOT_FOUND.getMessage(),
                        String.format(EMPLOYEE_NOT_FOUND.getDetailMessage(), id)));
        employee.setName(employeeDto.getName());
        employee.setAge(employeeDto.getAge());
        employee.setJoiningDate(employeeDto.getJoiningDate());
        employee.setStatus(employeeDto.getStatus());
        Employee updatedEmployee = employeeRepository.save(employee);
        return employeeMapper.toDto(updatedEmployee);
    }

    @Override
    public void deleteEmployeeById(long id) {
        employeeRepository.deleteById(id);
    }

}
