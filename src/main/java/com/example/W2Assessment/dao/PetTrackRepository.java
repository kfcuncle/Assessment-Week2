package com.example.W2Assessment.dao;

import com.example.W2Assessment.entity.Owner;
import com.example.W2Assessment.entity.Pet;

import java.time.LocalDate;
import java.util.List;

public interface PetTrackRepository {
    void save(Owner owner);

    void save(Pet pet);

    void delete(int petId);

    void update(Pet pet);

    Owner findOwnerById(int ownerId);
    Pet findPetById(int petId);

    Owner findOwnerByPetId(int petId);

    List<Pet> findAllPetByOwnerId(int ownerId);

    List<Owner> findOwnerByDateCreated(LocalDate dateCreated);

    List<Owner> findAll();

}
