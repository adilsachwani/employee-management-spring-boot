package com.backend.employeemanagement.controller.v1;

import com.backend.employeemanagement.constant.AttendanceAction;
import com.backend.employeemanagement.dto.EmployeeDto;
import com.backend.employeemanagement.dto.EmployeeHistoryDto;
import com.backend.employeemanagement.service.EmployeeHistoryService;
import com.backend.employeemanagement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmployeeHistoryService employeeHistoryService;

    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployees(){
        List<EmployeeDto> employees = employeeService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long id){
        EmployeeDto employee = employeeService.getEmployeeById(id);
        return ResponseEntity.ok(employee);
    }

    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@Valid @RequestBody EmployeeDto employeeDto){
        EmployeeDto employee  = employeeService.createEmployee(employeeDto);
        return ResponseEntity.ok(employee);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") Long id, @RequestBody EmployeeDto employeeDto){
        EmployeeDto employee  = employeeService.updateEmployee(id, employeeDto);
        return ResponseEntity.ok(employee);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployeeById(@PathVariable("id") Long id){
        employeeService.deleteEmployeeById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/check-in")
    public ResponseEntity<EmployeeHistoryDto> checkInEmployee(@PathVariable("id") Long id){
        EmployeeHistoryDto employeeHistory = employeeHistoryService.addAttendance(id, AttendanceAction.CHECK_IN);
        return ResponseEntity.ok(employeeHistory);
    }

    @PostMapping("/{id}/check-out")
    public ResponseEntity<EmployeeHistoryDto> checkOutEmployee(@PathVariable("id") Long id){
        EmployeeHistoryDto employeeHistory = employeeHistoryService.addAttendance(id, AttendanceAction.CHECK_OUT);
        return ResponseEntity.ok(employeeHistory);
    }

}
