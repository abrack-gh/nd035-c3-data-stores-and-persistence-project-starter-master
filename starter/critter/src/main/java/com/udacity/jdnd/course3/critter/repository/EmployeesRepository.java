package com.udacity.jdnd.course3.critter.repository;

import com.udacity.jdnd.course3.critter.entity.Customers;
import com.udacity.jdnd.course3.critter.entity.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.DayOfWeek;
import java.util.List;

@Repository
public interface EmployeesRepository extends JpaRepository<Employees, Long> {

    @Query("Select employee from Employees employee")
    List<Employees> getAllEmployees();

    @Query("Select employee from Employees employee where employee.id = :employeeId")
    Employees getEmployeeById(@Param("employeeId") Long employeeId);

    @Query("Select employee from Employees employee"
            + "Where :employeeDOWAvailable MEMBER OF employee.employeeDOWAvailable")
    Employees getEmployeeAvailability(@Param("employeeDOWAvailable")DayOfWeek dayOfWeek);
}


