package com.example.W2Assessment.service;

import com.example.W2Assessment.entity.Owner;
import com.example.W2Assessment.entity.Pet;

import java.time.LocalDate;
import java.util.List;

public interface OwnerService {
    void save(Owner owner);
    Owner findOwnerByPetId(Integer petId);
    List<Owner> findOwnerByDateCreated(LocalDate dateCreated);
    List<Owner> findAll();
}
