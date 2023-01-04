package com.udacity.jdnd.course3.critter.controllers;


import com.udacity.jdnd.course3.critter.dto.CustomerDTO;
import com.udacity.jdnd.course3.critter.dto.PetDTO;
import com.udacity.jdnd.course3.critter.entity.Pet;
import com.udacity.jdnd.course3.critter.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pet")
public class PetController {

    @Autowired
    PetService petService;

    @PostMapping("/pet")
    public PetDTO savePet(@RequestBody PetDTO petDTO){

        return petService.savePet(petDTO);
    }

    @GetMapping("/{petId}")
    public PetDTO getPetById(@PathVariable long petId){
        return petService.getPet(petId);
    }

    @GetMapping
    public List<Pet> getPets(){
        return petService.getAllPets();
    }

    @GetMapping("/customer/{ownerId}")
    public List<Pet> getPetsByOwner(@PathVariable Long ownerId){
        return petService.getPetsByOwner(ownerId);
    }



}
