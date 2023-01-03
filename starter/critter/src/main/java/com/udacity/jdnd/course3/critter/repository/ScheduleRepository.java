package com.udacity.jdnd.course3.critter.repository;

import com.udacity.jdnd.course3.critter.entity.Pet;
import com.udacity.jdnd.course3.critter.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

    @Query("Select schedule from Schedule schedule")
    List<Schedule> getAllSchedules();

    @Query("Select schedule from Schedule schedule" +
    "INNER JOIN schedule.pet sp" +
    "WHERE sp.id = petId")
    List<Schedule> getAllSchedulesByPetId(@Param("petId") Long petId);

    @Query("SELECT schedule from Schedule schedule" +
    "INNER JOIN schedule.employees se"+
    "WHERE se.id = :employeeId")
    List<Schedule> getAllSchedulesByEmployeeId(@Param("employeeId") Long employeeId);

}
