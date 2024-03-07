package com.example.W2Assessment.service;

import com.example.W2Assessment.entity.Owner;
import com.example.W2Assessment.entity.Pet;

import java.time.LocalDate;
import java.util.List;


public interface PetTrackService {
    void save(Owner owner);
    void save(Pet pet, int ownerId);

    void delete(int petId);

    void update(Pet pet);

    Owner findOwnerByPetId(int petId);

    Pet findPetById(int petId);

    List<Pet> findAllPetByOwnerId(int ownerId);

    List<Owner> findOwnerByDateCreated(LocalDate dateCreated);

    List<Owner> findAll();


}
