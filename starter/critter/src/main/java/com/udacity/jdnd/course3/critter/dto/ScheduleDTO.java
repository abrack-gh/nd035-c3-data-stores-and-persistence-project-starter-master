package com.udacity.jdnd.course3.critter.dto;

import com.udacity.jdnd.course3.critter.enums.EmployeeSkill;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

public class ScheduleDTO {
    private Long id;
    private List<Long> employeeId;
    private List<Long> petId;
    private Set<EmployeeSkill> skills;
    private LocalDateTime localDateTime;

}
