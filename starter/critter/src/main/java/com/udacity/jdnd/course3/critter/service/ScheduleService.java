package com.udacity.jdnd.course3.critter.service;

import com.udacity.jdnd.course3.critter.dto.ScheduleDTO;
import com.udacity.jdnd.course3.critter.entity.Customers;
import com.udacity.jdnd.course3.critter.entity.Employees;
import com.udacity.jdnd.course3.critter.entity.Pet;
import com.udacity.jdnd.course3.critter.entity.Schedule;
import com.udacity.jdnd.course3.critter.repository.CustomersRepository;
import com.udacity.jdnd.course3.critter.repository.EmployeesRepository;
import com.udacity.jdnd.course3.critter.repository.PetRepository;
import com.udacity.jdnd.course3.critter.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ScheduleService {

    @Autowired
    ScheduleRepository scheduleRepository;
    @Autowired
    CustomersRepository customersRepository;
    @Autowired
    PetRepository petRepository;
    @Autowired
    EmployeesRepository employeesRepository;


    public List<Schedule> getAllSchedules(){
        List<Schedule> schedules = scheduleRepository.getAllSchedules();

        return schedules;
    }

    public Schedule getScheduleById(Long scheduleId){
        Schedule schedule = (Schedule) scheduleRepository.getScheduleById(scheduleId);

        return schedule;
    }

    public List<Schedule> getAllSchedulesByPetId(Long petId){
        Schedule schedulesByPetId = (Schedule) scheduleRepository.getAllSchedulesByPetId(petId);

        return (List<Schedule>) schedulesByPetId;
    }

    public List<Schedule> getAllSchedulesByEmployeeId(Long employeeId){
        Schedule schedule = (Schedule) scheduleRepository.getAllSchedulesByEmployeeId(employeeId);

        return (List<Schedule>) schedule;
    }

    public Employees getEmployeeId(Long id){
        Employees employeeId = employeesRepository.getEmployeeById(id);


        return employeeId;
    }

    public ScheduleDTO saveSchedule(ScheduleDTO scheduleDTO){
        List<Pet> pets = petRepository.findAllById(scheduleDTO.getPetId());
        List<Employees> employees = employeesRepository.findAllById(scheduleDTO.getEmployeeId());

        Schedule schedule = new Schedule(employees, pets, scheduleDTO.getLocalDate(),scheduleDTO.getActivities());

        Schedule savedSchedule = scheduleRepository.save(schedule);


        return scheduleDTO;
    }

    public List<Schedule> getScheduleForEmployee(Long employeeId){
        return scheduleRepository.getAllSchedulesByEmployeeId(employeeId);
    }

    public List<Schedule> getScheduleForPet(Long petId){
        return scheduleRepository.getAllSchedulesByPetId(petId);
    }

    public List<ScheduleDTO> getScheduleForCustomer(Long customerId){
        Optional<Customers> customer = customersRepository.findById(customerId);
        List<ScheduleDTO> result = new ArrayList<>();

        Customers owner = null;

        if(customer.isPresent()){
            owner = customer.get();
        }
        return result;
    }


}
