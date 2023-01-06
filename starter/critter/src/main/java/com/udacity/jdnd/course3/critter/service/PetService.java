package com.udacity.jdnd.course3.critter.service;

import com.udacity.jdnd.course3.critter.controllers.PetController;
import com.udacity.jdnd.course3.critter.dto.PetDTO;
import com.udacity.jdnd.course3.critter.entity.Customers;
import com.udacity.jdnd.course3.critter.entity.Pet;
import com.udacity.jdnd.course3.critter.repository.CustomersRepository;
import com.udacity.jdnd.course3.critter.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PetService {

    @Autowired
    PetRepository petRepository;
    @Autowired
    PetController petController;
    @Autowired
    CustomersRepository customersRepository;

    public PetDTO savePet(PetDTO petDTO){
        Customers customer = customersRepository.findById(petDTO.getOwnerId()).get();
        Pet pet = petDTO.toEntity(petDTO, customer);
        customer.addPet(pet);

        Pet savedPet = petRepository.save(pet);
        return petDTO;
    }

    public PetDTO getPet(Long id){
        Pet pet = petRepository.findById(id).get();

        return new PetDTO(pet);
    }

    public List<Pet> getAllPets(){
        return ((List<Pet>)petRepository.findAll().stream().toList());
    }

    public List<Pet> getPetsByOwner(Long ownerId){
        return(petRepository.getPetByCustomerId(ownerId)).stream().toList();

    }



}
