package com.backend.employeemanagement.controller.v1;

import com.backend.employeemanagement.constant.AttendanceAction;
import com.backend.employeemanagement.dto.EmployeeDto;
import com.backend.employeemanagement.dto.EmployeeHistoryDto;
import com.backend.employeemanagement.service.EmployeeHistoryService;
import com.backend.employeemanagement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmployeeHistoryService employeeHistoryService;

    @GetMapping
    public List<EmployeeDto> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public EmployeeDto getEmployeeById(@PathVariable("id") Long id){
        return employeeService.getEmployeeById(id);
    }

    @PostMapping
    public EmployeeDto createEmployee(@Valid @RequestBody EmployeeDto employeeDto){
        return employeeService.createEmployee(employeeDto);
    }

    @PutMapping("/{id}")
    public EmployeeDto updateEmployee(@PathVariable("id") Long id, @RequestBody EmployeeDto employeeDto){
        return employeeService.updateEmployee(id, employeeDto);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployeeById(@PathVariable("id") Long id){
        employeeService.deleteEmployeeById(id);
    }

    @PostMapping("/{id}/check-in")
    public EmployeeHistoryDto checkInEmployee(@PathVariable("id") Long id){
        return employeeHistoryService.addAttendance(id, AttendanceAction.CHECK_IN);
    }

    @PostMapping("/{id}/check-out")
    public EmployeeHistoryDto checkOutEmployee(@PathVariable("id") Long id){
        return employeeHistoryService.addAttendance(id, AttendanceAction.CHECK_OUT);
    }

}
