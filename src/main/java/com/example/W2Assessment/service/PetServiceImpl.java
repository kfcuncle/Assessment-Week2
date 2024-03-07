package com.example.W2Assessment.service;

import com.example.W2Assessment.dao.OwnerRepository;
import com.example.W2Assessment.dao.PetRepository;
import com.example.W2Assessment.entity.Owner;
import com.example.W2Assessment.entity.Pet;
import com.example.W2Assessment.exception.NoSuchPetExistsException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class PetServiceImpl implements PetService {

    private final PetRepository petRepository;
    private final OwnerRepository ownerRepository;

    public PetServiceImpl(PetRepository petRepository, OwnerRepository ownerRepository) {
        this.petRepository = petRepository;
        this.ownerRepository = ownerRepository;
    }

    @Override
    @Transactional
    public void save(Pet pet, Integer ownerId) {
        Owner owner = ownerRepository.findOwnerById(ownerId);
        pet.setOwner(owner);
        pet.setDateCreated(LocalDate.now());
        pet.setDateModified(LocalDate.now());
        petRepository.save(pet);
    }

    @Override
    @Transactional
    public void delete(Integer petId) {
        if (petRepository.findPetById(petId) != null) {
            petRepository.delete(petId);
        } else {
            throw new NoSuchPetExistsException(
                    "No Such Customer exists!!");
        }
    }

    @Override
    @Transactional
    public void update(Pet pet) {
        Owner owner = ownerRepository.findOwnerByPetId(pet.getId());
        Pet tempPet = petRepository.findPetById(pet.getId());
        pet.setOwner(owner);
        pet.setDateCreated(tempPet.getDateCreated());
        pet.setDateModified(LocalDate.now());
        petRepository.update(pet);
    }

    @Override
    public Pet findPetById(Integer petId) {
        return petRepository.findPetById(petId);
    }

    @Override
    public List<Pet> findAllPetByOwnerId(Integer ownerId) {
        return petRepository.findAllPetByOwnerId(ownerId);
    }
}
