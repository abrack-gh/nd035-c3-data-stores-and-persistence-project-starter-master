package com.udacity.jdnd.course3.critter.entity;

import com.udacity.jdnd.course3.critter.service.PetService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.*;

@Entity
public class Customers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String fistName;
    private String lastName;
    private String phoneNumber;

    @OneToMany(mappedBy = "customers", cascade = CascadeType.ALL)
    private List<Pet> pets;

    public Customers() {
    }

    public Customers(Long id, String fistName, String lastName, String phoneNumber, List<Pet> pets) {
        this.id = id;
        this.fistName = fistName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.pets = pets;
    }

    public Customers(String firstName, String lastName, String phoneNumber) {

    }

    public Long getId() {
        return id;
    }

    private static final Logger logger = LoggerFactory.getLogger(Customers.class);

    public List<Pet> getPets() {
        return pets;
    }

    public List<Pet> getPetsById(Long petId){
        return this.getPetsById(petId);
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }

    public void addPet(Pet pet){
        if(pets == null){
            pets = new ArrayList<>();
        }
        pets.add(pet);
    }

    public Map<Pet, Pet> getPetId() {
        return getPetId();
    }
}
