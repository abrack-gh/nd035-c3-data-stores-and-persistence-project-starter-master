package com.udacity.jdnd.course3.critter.controllers;

import com.udacity.jdnd.course3.critter.dto.EmployeeDTO;
import com.udacity.jdnd.course3.critter.dto.EmployeeRequestDTO;
import com.udacity.jdnd.course3.critter.entity.Employees;
import com.udacity.jdnd.course3.critter.repository.EmployeesRepository;
import com.udacity.jdnd.course3.critter.repository.PetRepository;
import com.udacity.jdnd.course3.critter.service.EmployeeService;
import com.udacity.jdnd.course3.critter.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.DayOfWeek;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/customers")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private EmployeesRepository employeesRepository;
    @Autowired
    private EmployeeDTO employeeDTO;
    @Autowired
    private PetRepository petRepository;
    @Autowired
    private PetService petService;


    @PostMapping("/employee")
    public EmployeeDTO saveEmployee(@RequestBody EmployeeDTO employeeDTO){

        return employeeDTO;
    }

    @GetMapping("/employee")
    public List<Employees> getAllEmployees(Long id){
        return employeeService.getAllEmployees();
    }

    @GetMapping("/employee/{employeeId}")
    public EmployeeDTO getEmployeeById(@PathVariable long employeeId){
        return employeeService.getEmployeeById(employeeId);
    }

    @PutMapping("/employee/{employeeId}/")
    public void setAvailability(@RequestBody Set<DayOfWeek> daysAvailable, @PathVariable long employeeId){
        employeeService.setAvailability(daysAvailable,employeeId);
    }

    @GetMapping("/employee/availability")
    public List<EmployeeDTO> findEmployeeForService(@RequestBody EmployeeRequestDTO employeeRequestDTO){
        return employeeService.findEmployeesForService(employeeRequestDTO);
    }




}
