package com.backend.employeemanagement.model;

import com.backend.employeemanagement.constant.AttendanceAction;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "employee_history")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_history_id")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "action")
    private AttendanceAction action;

    @Column(name = "date_time")
    private LocalDateTime dateTime;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id")
    private Employee employee;

}
