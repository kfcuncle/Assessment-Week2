package com.example.W2Assessment.service;

import com.example.W2Assessment.entity.Owner;
import com.example.W2Assessment.entity.Pet;

import java.time.LocalDate;
import java.util.List;

public interface PetService {
    void save(Pet pet, Integer ownerId);
    void delete(Integer petId);
    void update(Pet pet);
    Pet findPetById(Integer petId);
    List<Pet> findAllPetByOwnerId(Integer ownerId);

}
