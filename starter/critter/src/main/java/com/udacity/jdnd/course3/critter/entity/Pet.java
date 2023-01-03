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
}
