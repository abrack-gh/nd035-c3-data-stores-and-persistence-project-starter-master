package com.udacity.jdnd.course3.critter.service;

import com.udacity.jdnd.course3.critter.dto.CustomerDTO;
import com.udacity.jdnd.course3.critter.entity.Customers;
import com.udacity.jdnd.course3.critter.entity.Pet;
import com.udacity.jdnd.course3.critter.repository.CustomersRepository;
import com.udacity.jdnd.course3.critter.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CustomerService {

    @Autowired
    CustomersRepository customersRepository;

    @Autowired
    PetRepository petRepository;

    @Autowired
    CustomerDTO customerDTO;

    public List<Customers> getAllCustomers(){
        return customersRepository.getCustomers();
    }

    public CustomerService(CustomersRepository customersRepository, PetRepository petRepository, CustomerDTO customerDTO) {
        this.customersRepository = customersRepository;
        this.petRepository = petRepository;
        this.customerDTO = customerDTO;
    }

    public CustomersRepository getCustomersRepository() {
        return customersRepository;
    }

    public void setCustomersRepository(CustomersRepository customersRepository) {
        this.customersRepository = customersRepository;
    }

    public PetRepository getPetRepository() {
        return petRepository;
    }

    public void setPetRepository(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    public CustomerDTO getCustomerDTO() {
        return customerDTO;
    }

    public void setCustomerDTO(CustomerDTO customerDTO) {
        this.customerDTO = customerDTO;
    }

    public Customers getCustomerById(Long customerId){
        Customers customers = customersRepository.getCustomerById(customerId);

        return customers;
    }

    public Customers getCustomerByPetId(Long petId){
        Customers customers = customersRepository.getCustomerByPetId(petId);

        return customers;
    }

    public Customers deleteCustomerById(Long customerId){
        Customers customer = customersRepository.getCustomerById(customerId);

        return customer;
    }

    public Customers addPetToCustomer(Pet pets, Customers customer){
        List<Pet> listOfCustomerPets = customer.getPets();

        if(listOfCustomerPets.isEmpty()){
            listOfCustomerPets = new ArrayList<Pet>();
            Pet pet;
        }
        listOfCustomerPets.add(pets);
        customer.setPets((List<Pet>) pets);
        customersRepository.save(customer);

        return customer;
    }

    public CustomerDTO saveCustomer(Customers Customer, CustomerDTO customerDTO){
        Customers customers = new Customers(customerDTO.getFirstName(), customerDTO.getLastName(), customerDTO.getPhoneNumber();
        Customers savedCustomer = customersRepository.save(customers);

        return customerDTO;
    }
    
}
