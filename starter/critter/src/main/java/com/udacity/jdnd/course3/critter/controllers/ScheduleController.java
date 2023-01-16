package com.udacity.jdnd.course3.critter.controllers;


import com.udacity.jdnd.course3.critter.dto.ScheduleDTO;
import com.udacity.jdnd.course3.critter.entity.Schedule;
import com.udacity.jdnd.course3.critter.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ScheduleController {

    @Autowired
    ScheduleService scheduleService;

    @GetMapping("/schedule")
    public List<Schedule> getAllSchedules(){

        return scheduleService.getAllSchedules();
    }

    @PostMapping
    public ScheduleDTO createSchedule(@RequestBody ScheduleDTO scheduleDTO){
        return scheduleService.saveSchedule(scheduleDTO);
    }

    @GetMapping("/employee/{employeeId")
    public List<Schedule> getScheduleForEmployee(@PathVariable long employeeId){

        return scheduleService.getScheduleForEmployee(employeeId);
    }

    @GetMapping("/pet/{petId")
    public List<Schedule> getScheduleForPet(@PathVariable long petId){

        return scheduleService.getScheduleForPet(petId);
    }

    @GetMapping("/customer/{customerId}")
    public List<ScheduleDTO> getScheduleForCustomer(@PathVariable long customerId){

        return scheduleService.getScheduleForCustomer(customerId);
    }
}
