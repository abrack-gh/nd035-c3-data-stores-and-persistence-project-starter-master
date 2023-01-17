package com.udacity.jdnd.course3.critter.repository;

import com.udacity.jdnd.course3.critter.entity.Customers;
import com.udacity.jdnd.course3.critter.entity.Pet;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public interface PetRepository extends JpaRepository<Pet, Long> {

    @Query("Select pet from Pets pet")
    List<Pet> getAllPets();

    @Query("Select pet from Pets pet where pet.id = :petId")
    Pet getPetById(@Param("petId") Long petId);;

    @Query("Select pet from Pets pet where pet.customer.id = :customerId")
    List<Pet> getPetByCustomerId(@Param("customerId") Long customerId);
}
