package com.example.W2Assessment.dao;

import com.example.W2Assessment.entity.Owner;

import java.time.LocalDate;
import java.util.List;

public interface OwnerRepository {
    void save(Owner owner);
    Owner findOwnerById(int ownerId);
    Owner findOwnerByPetId(int petId);
    List<Owner> findOwnerByDateCreated(LocalDate dateCreated);
    List<Owner> findAll();
}
