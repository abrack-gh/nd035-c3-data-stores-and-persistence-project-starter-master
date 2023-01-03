package com.udacity.jdnd.course3.critter.entity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;
import java.util.List;

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

    private static final Logger logger = LoggerFactory.getLogger(Customers.class);

}
