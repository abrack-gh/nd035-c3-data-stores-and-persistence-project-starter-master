package com.udacity.jdnd.course3.critter.dto;

import com.udacity.jdnd.course3.critter.enums.EmployeeSkill;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

public class ScheduleDTO {
    private Long id;
    private List<Long> employeeId;
    private List<Long> petId;
    private Set<EmployeeSkill> activities;
    private LocalDate localDate;

    public ScheduleDTO(Long id, List<Long> employeeId, List<Long> petId, Set<EmployeeSkill> activities, LocalDate localDate) {
        this.id = id;
        this.employeeId = employeeId;
        this.petId = petId;
        this.activities = activities;
        this.localDate = localDate;
    }

    public ScheduleDTO() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Long> getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(List<Long> employeeId) {
        this.employeeId = employeeId;
    }

    public List<Long> getPetId() {
        return petId;
    }

    public void setPetId(List<Long> petId) {
        this.petId = petId;
    }

    public Set<EmployeeSkill> getActivities() {
        return activities;
    }

    public void setActivities(Set<EmployeeSkill> activities) {
        this.activities = activities;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }
}
