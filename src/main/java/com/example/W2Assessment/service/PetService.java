package com.example.W2Assessment.service;

import com.example.W2Assessment.entity.Owner;
import com.example.W2Assessment.entity.Pet;

import java.time.LocalDate;
import java.util.List;

public interface PetService {
    void save(Pet pet, int ownerId);
    void delete(int petId);
    void update(Pet pet);
    Pet findPetById(int petId);
    List<Pet> findAllPetByOwnerId(int ownerId);

}
