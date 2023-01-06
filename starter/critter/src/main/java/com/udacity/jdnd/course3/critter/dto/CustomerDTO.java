package com.udacity.jdnd.course3.critter.dto;


import com.udacity.jdnd.course3.critter.entity.Customers;

import java.util.List;

public class CustomerDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private List<Long> petId;

    public CustomerDTO(Long id, String firstName, String lastName, String phoneNumber, List<Long> petId) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.petId = petId;
    }

    public CustomerDTO(Customers customers) {
    }

    public CustomerDTO() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Long> getPetId() {
        return petId;
    }

    public void setPetId(List<Long> petId) {
        this.petId = petId;
    }
}
