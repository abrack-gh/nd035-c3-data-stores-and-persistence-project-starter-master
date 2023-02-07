package com.udacity.jdnd.course3.critter.repository;

import com.udacity.jdnd.course3.critter.entity.Customers;
import com.udacity.jdnd.course3.critter.entity.Employees;
import com.udacity.jdnd.course3.critter.enums.EmployeeSkill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.DayOfWeek;
import java.util.List;
import java.util.Set;

@Repository
@Transactional
public interface EmployeesRepository extends JpaRepository<Employees, Long> {

    @Query("Select employee from Employees employee")
    List<Employees> getAllEmployees();

    @Query("Select employee from Employees employee where employee.id = :employeeId")
    Employees getEmployeeById(@Param("employeeId") Long employeeId);

    @Query("Select employee from Employees employee"
            + "Where :employeeDOWAvailable MEMBER OF employee.employeeDOWAvailable")
    Employees getEmployeeAvailability(@Param("employeeDOWAvailable") DayOfWeek dayOfWeek);

    List<Employees> getEmployeeBySkillAndAvailability(Set<EmployeeSkill> skills,Set<DayOfWeek> day);

}


