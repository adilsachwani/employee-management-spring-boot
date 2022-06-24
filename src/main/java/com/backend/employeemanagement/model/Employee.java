package com.backend.employeemanagement.model;

import com.backend.employeemanagement.constant.EmployeeStatus;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "employee")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private Integer age;

    @Column(name = "joining_date")
    private LocalDate joiningDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private EmployeeStatus status;

}
