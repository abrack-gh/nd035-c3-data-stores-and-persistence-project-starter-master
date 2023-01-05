package com.udacity.jdnd.course3.critter.service;

import com.udacity.jdnd.course3.critter.dto.EmployeeDTO;
import com.udacity.jdnd.course3.critter.dto.EmployeeRequestDTO;
import com.udacity.jdnd.course3.critter.entity.Employees;
import com.udacity.jdnd.course3.critter.enums.EmployeeSkill;
import com.udacity.jdnd.course3.critter.repository.EmployeesRepository;
import com.udacity.jdnd.course3.critter.repository.PetRepository;
import org.hibernate.annotations.NamedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    @Autowired
    EmployeesRepository employeesRepository;

    @Autowired
    PetRepository petRepository;

    @Autowired
    EmployeeDTO employeeDTO;

    private final Logger logger = Logger.getLogger(String.valueOf(EmployeeService.class));

    public EmployeeDTO saveEmployee(Employees employees, EmployeeDTO employeeDTO) {
        Employees employee = new Employees(employeeDTO.getFirstName(), employeeDTO.getLastName(), employeeDTO.getPhoneNumber());
        Employees savedEmployee = employeesRepository.save(employees);

        return employeeDTO;
    }

    public List<Employees> getAllEmployees() {
        return this.employeesRepository.getAllEmployees();
    }

    public EmployeeDTO getEmployeeById(Long Id) {
        Optional<Employees> employee = employeesRepository.findById(Id);
        if (employee.isPresent()) {
            return new EmployeeDTO(employee.get());
        }
        return null;
    }

    public EmployeeDTO setAvailability(Set<DayOfWeek> daysAvailable, @PathVariable Long employeeId) {
        Optional<Employees> employees = employeesRepository.findById(employeeId);
        if (employees.isPresent()) {
            Employees empl = employees.get();
            empl.setEmployeeDOWAvailable(daysAvailable);
            employeesRepository.save(empl);
        } else {
            throw new RuntimeException("Error occurred");
        }
        return employeeDTO;
    }

    public static <T> Predicate<T> distinctByKey(
            Function<? super T, ?> keyExtractor) {

        Map<Object, Boolean> seen = new ConcurrentHashMap<>();
        return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }

    public List<EmployeeDTO> findEmployeesForService(EmployeeRequestDTO employeeDTO){
        Set<DayOfWeek> day = new HashSet<>();
        day.add(employeeDTO.getDate().getDayOfWeek());
        Set<EmployeeSkill> skills = employeeDTO.getSkills();
        List<Employees> employee = employeesRepository.getEmployeeBySkillAndAvailability(skills, day)
                .stream().filter(employee1 -> employee1.getSkills().containsAll(skills)).filter(distinctByKey(Employees::getId)) .collect(Collectors.toList());
        return  employee.stream().map(EmployeeDTO::new ).collect(Collectors.toList());
    }
}



