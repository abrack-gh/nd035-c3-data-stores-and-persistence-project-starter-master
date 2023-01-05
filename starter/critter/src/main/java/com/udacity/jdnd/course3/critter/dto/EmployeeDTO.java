package com.udacity.jdnd.course3.critter.dto;

import com.udacity.jdnd.course3.critter.entity.Employees;
import com.udacity.jdnd.course3.critter.enums.EmployeeSkill;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public class EmployeeDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private Set<EmployeeSkill> skills;
    private Set<DayOfWeek> employeeDOWAvailable;

    public EmployeeDTO(Employees employee) {
        this.id = employee.getId();
        this.firstName = employee.getFistName();
        this.lastName = employee.getLastName();
        this.phoneNumber = employee.getPhoneNumber();
        this.skills = employee.getSkills();
        this.employeeDOWAvailable = employee.getEmployeeDOWAvailable();
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Set<EmployeeSkill> getSkills() {

        return skills;
    }

    public void setSkills (Set<EmployeeSkill> setSkills){
        this.setSkills(setSkills);
    }

    public LocalDate getEmployeeDOWAvailable() {

        return getEmployeeDOWAvailable();
    }

    public void setDaysAvailable(Set<DayOfWeek> daysAvailable){
        this.setDaysAvailable(daysAvailable);
    }

    public Set<Employees> getEmployeeBySkillsAndDaysAvailable(Set<EmployeeSkill> skills, Set<DayOfWeek> day){
        return this.getEmployeeBySkillsAndDaysAvailable(skills, day);
    }
}
