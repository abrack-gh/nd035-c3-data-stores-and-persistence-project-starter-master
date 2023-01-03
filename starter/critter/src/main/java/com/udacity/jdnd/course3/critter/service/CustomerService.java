package com.udacity.jdnd.course3.critter.service;

import com.udacity.jdnd.course3.critter.entity.Customers;
import com.udacity.jdnd.course3.critter.entity.Pet;
import com.udacity.jdnd.course3.critter.repository.CustomersRepository;
import com.udacity.jdnd.course3.critter.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {

    @Autowired
    CustomersRepository customersRepository;

    @Autowired
    PetRepository petRepository;

    public List<Customers> getAllCustomers(){
        return customersRepository.getCustomers();
    }

    public Customers getCustomerById(Long customerId){
        Customers customers = customersRepository.getCustomerById(customerId);

        return customers;
    }

    public Customers getCustomerByPetId(Long petId){
        Customers customers = customersRepository.getCustomerByPetId(petId);

        return customers;
    }

    public Customers saveCustomer(Customers customer){
        Customers newCustomer = customersRepository.save(customer);

        return newCustomer;
    }

    public Customers deleteCustomerById(Long customerId){
        Customers customer = customersRepository.getCustomerById(customerId);

        return customer;
    }

    public Customers addPetToCustomer(Pet pets, Customers customer){
        List<Pet> listOfPets = customer.getPets();

        if(listOfPets.isEmpty()){
            listOfPets = new ArrayList<>();
        }
        listOfPets.add(pet);
        customer.setPets(listOfPets);
        customersRepository.save(customer);

        return customer;
    }
}
