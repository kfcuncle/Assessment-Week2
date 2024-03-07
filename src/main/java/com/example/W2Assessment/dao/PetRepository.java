package com.example.W2Assessment.dao;

import com.example.W2Assessment.entity.Owner;
import com.example.W2Assessment.entity.Pet;

import java.util.List;

public interface PetRepository {
    void save(Pet pet);
    Owner findOwnerById(Integer ownerId);
    Owner findOwnerByPetId(Integer petId);
    void delete(Integer petId);
    void update(Pet pet);
    Pet findPetById(Integer petId);
    List<Pet> findAllPetByOwnerId(Integer ownerId);
}
