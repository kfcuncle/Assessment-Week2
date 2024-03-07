package com.example.W2Assessment.dao;

import com.example.W2Assessment.entity.Owner;
import com.example.W2Assessment.entity.Pet;

import java.util.List;

public interface PetRepository {
    void save(Pet pet);
    Owner findOwnerById(int ownerId);
    Owner findOwnerByPetId(int petId);
    void delete(int petId);
    void update(Pet pet);
    Pet findPetById(int petId);
    List<Pet> findAllPetByOwnerId(int ownerId);
}
