package com.example.W2Assessment.dao;

import com.example.W2Assessment.entity.Pet;

import java.util.List;

public interface PetRepository {
    void save(Pet pet);

    void delete(Integer petId);

    void update(Pet pet);

    Pet findPetById(Integer petId);

    List<Pet> findAllPetByOwnerId(Integer ownerId);
}
