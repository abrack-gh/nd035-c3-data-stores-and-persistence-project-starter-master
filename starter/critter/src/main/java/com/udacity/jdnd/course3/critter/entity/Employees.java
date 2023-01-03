package com.udacity.jdnd.course3.critter.entity;

import com.udacity.jdnd.course3.critter.enums.EmployeeSkill;

import javax.persistence.*;
import java.time.DayOfWeek;
import java.util.List;
import java.util.Set;

@Entity
public class Employees {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String fistName;
    private String lastName;
    private String phoneNumber;

    @ElementCollection
    @JoinTable(name = "skill")
    private Set<EmployeeSkill> Skills;

    @ElementCollection
    @JoinTable(name = "employeeAvailability")
    @Column(name = "availability")
    private Set<DayOfWeek> employeeDOWAvailable;

}