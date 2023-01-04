package com.udacity.jdnd.course3.critter.service;

import com.udacity.jdnd.course3.critter.dto.CustomerDTO;
import com.udacity.jdnd.course3.critter.dto.EmployeeDTO;
import com.udacity.jdnd.course3.critter.entity.Customers;
import com.udacity.jdnd.course3.critter.entity.Employees;
import com.udacity.jdnd.course3.critter.repository.CustomersRepository;
import com.udacity.jdnd.course3.critter.repository.EmployeesRepository;
import com.udacity.jdnd.course3.critter.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    EmployeesRepository employeesRepository;

    @Autowired
    PetRepository petRepository;

    @Autowired
    EmployeeDTO employeeDTO;

    public EmployeeDTO saveEmployee(Employees employees, EmployeeDTO employeeDTO){
        Employees employee = new Employees(employeeDTO.getFirstName(), employeeDTO.getLastName(), employeeDTO.getPhoneNumber());
        Employees savedEmployee = employeesRepository.save(employees);

        return employeeDTO;
    }

    public List<Employees> getAllEmployees() {
        return this.employeesRepository.getAllEmployees();
    }

    public EmployeeDTO getEmployeeById(Long Id){
        Optional<Employees> employee = employeesRepository.findById(Id);
        if(employee.isPresent()){
            return new EmployeeDTO(employee.get());
        }
    }
}
