package com.udacity.jdnd.course3.critter.entity;

import com.udacity.jdnd.course3.critter.enums.EmployeeSkill;

import java.time.DayOfWeek;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

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

    public void setId(Long id) {
        this.id = id;
    }

    public void setFistName(String fistName) {
        this.fistName = fistName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setSkills(Set<EmployeeSkill> skills) {
        Skills = skills;
    }

    public void setEmployeeDOWAvailable(Set<DayOfWeek> employeeDOWAvailable) {
        this.employeeDOWAvailable = employeeDOWAvailable;
    }

    public Employees(String firstName, String lastName, String phoneNumber) {

    }

    public Long getId() {
        return id;
    }

    public String getFistName() {
        return fistName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Set<EmployeeSkill> getSkills() {
        return Skills;
    }

    public Set<DayOfWeek> getEmployeeDOWAvailable() {
        return employeeDOWAvailable;
    }

    public Employees() {

    }
}
