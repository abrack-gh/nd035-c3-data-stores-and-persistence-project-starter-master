package com.udacity.jdnd.course3.critter.repository;

import com.udacity.jdnd.course3.critter.entity.Customers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface CustomersRepository extends JpaRepository<Customers, Long> {

    @Query("Select customer from Customer customer")
    List<Customers> getCustomers();

    @Query("Select customer from Customer customer where customer.id = :customerId")
    Customers getCustomerById(Long customerId);

    @Query("Select customer from Customer customer"
    + "INNER JOIN Pet pet on customer.id = pet.customer.id" +
    "where pet.id = :petId")
    Customers getCustomerByPetId(@Param("petId") Long petId);
}