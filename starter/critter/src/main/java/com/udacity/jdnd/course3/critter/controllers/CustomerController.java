package com.udacity.jdnd.course3.critter.controllers;

import com.udacity.jdnd.course3.critter.dto.CustomerDTO;
import com.udacity.jdnd.course3.critter.entity.Customers;
import com.udacity.jdnd.course3.critter.repository.CustomersRepository;
import com.udacity.jdnd.course3.critter.repository.PetRepository;
import com.udacity.jdnd.course3.critter.service.CustomerService;
import com.udacity.jdnd.course3.critter.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;
    @Autowired
    private CustomersRepository customersRepository;
    @Autowired
    private PetRepository petRepository;
    @Autowired
    private PetService petService;

    @PostMapping("/customer")
    public CustomerDTO saveCustomer(@RequestBody CustomerDTO customerDTO){

        return customerDTO;
    }

    @GetMapping("/customer")
    public List<Customers> getAllCustomers(){
        return customerService.getAllCustomers();
    }


}
