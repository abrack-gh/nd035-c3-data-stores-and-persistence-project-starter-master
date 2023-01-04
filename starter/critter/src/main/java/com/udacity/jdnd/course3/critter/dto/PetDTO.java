package com.udacity.jdnd.course3.critter.dto;

import com.udacity.jdnd.course3.critter.entity.Customers;
import com.udacity.jdnd.course3.critter.entity.Pet;
import com.udacity.jdnd.course3.critter.enums.PetType;

public class PetDTO {

    private Long id;
    private String name;
    private PetType petType;
    private Integer age;
    private String notes;
    private Long ownerId;

    public PetDTO(Pet pet) {
        this.id = pet.getId();
        this.name = pet.getName();
        this.petType = pet.getPetType();
        this.age = pet.getAge();
        this.notes = pet.getNotes();
        if(pet.getCustomers() !=null){
            this.ownerId = pet.getCustomers().getId();
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PetType getPetType() {
        return petType;
    }

    public void setPetType(PetType petType) {
        this.petType = petType;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public Pet toEntity(PetDTO petDTO, Customers customer){
        return new Pet(petDTO.getName(),petDTO.getPetType(), petDTO.getNotes(),customer, petDTO.getAge());
    }
}
