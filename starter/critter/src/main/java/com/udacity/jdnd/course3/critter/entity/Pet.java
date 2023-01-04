package com.udacity.jdnd.course3.critter.entity;

import com.udacity.jdnd.course3.critter.enums.PetType;

import javax.persistence.*;
import java.time.DayOfWeek;
import java.util.Set;

@Entity
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String name;
    private PetType petType;
    private Integer age;
    private String notes;

    @ElementCollection
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinTable(name = "customerId")
    private Customers customers;

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

    public Customers getCustomers() {
        return customers;
    }

    public void setCustomers(Customers customers) {
        this.customers = customers;
    }
}

