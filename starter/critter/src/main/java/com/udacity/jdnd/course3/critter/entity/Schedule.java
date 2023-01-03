package com.udacity.jdnd.course3.critter.entity;

import com.udacity.jdnd.course3.critter.enums.EmployeeSkill;

import javax.persistence.*;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Entity
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private LocalDateTime dateTime;

    @ManyToMany
    @JoinTable(
            name = "petSchedule",
            inverseJoinColumns = @JoinColumn(name="petId"))
    private List<Pet> pets;

    @ElementCollection
    @JoinTable(
            name = "employeeSkill")
    private Set<EmployeeSkill> skills;

}