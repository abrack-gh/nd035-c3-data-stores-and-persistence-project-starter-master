package com.udacity.jdnd.course3.critter.repository;

import com.udacity.jdnd.course3.critter.entity.Customers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomersRepository extends JpaRepository<Customers, Long> {

    @Query("Select customer from Customer customer")
    List<Customers> getCustomers();

    @Query("Select customer from Customer customer where customer.id = :customerId")
    Customers getCustomerById();

    @Query("Select customer from Customer customer"
    + "INNER JOIN Pet pet on customer.id = pet.customer.id" +
    "where pet.id = :petId")
    Customers getCustomerByPetId(@Param("petId") Long petId);
}