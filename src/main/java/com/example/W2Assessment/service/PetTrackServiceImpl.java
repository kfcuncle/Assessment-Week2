package com.example.W2Assessment.service;

import com.example.W2Assessment.dao.PetTrackRepository;
import com.example.W2Assessment.entity.Owner;
import com.example.W2Assessment.entity.Pet;
import com.example.W2Assessment.exception.NoSuchPetExistsException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class PetTrackServiceImpl implements PetTrackService{

    private PetTrackRepository petTrackRepository;

    public PetTrackServiceImpl(PetTrackRepository petTrackRepository) {
        this.petTrackRepository = petTrackRepository;
    }

    @Override
    @Transactional
    public void save(Owner owner) {
        owner.setDateCreated(LocalDate.now());
        owner.setDateModified(LocalDate.now());
        petTrackRepository.save(owner);
    }

    @Override
    @Transactional
    public void save(Pet pet, int ownerId) {
        Owner owner = petTrackRepository.findOwnerById(ownerId);
        pet.setOwner(owner);
        pet.setDateCreated(LocalDate.now());
        pet.setDateModified(LocalDate.now());
        petTrackRepository.save(pet);
    }

    @Override
    @Transactional
    public void delete(int petId) {
        if(petTrackRepository.findPetById(petId) != null){
            petTrackRepository.delete(petId);
        } else {
            throw new NoSuchPetExistsException(
                    "No Such Customer exists!!");
        }
    }

    @Override
    @Transactional
    public void update(Pet pet) {
        Owner owner = petTrackRepository.findOwnerByPetId(pet.getId());
        Pet tempPet = petTrackRepository.findPetById(pet.getId());
        pet.setOwner(owner);
        pet.setDateCreated(tempPet.getDateCreated());
        pet.setDateModified(LocalDate.now());
        petTrackRepository.update(pet);
    }

    @Override
    public Owner findOwnerByPetId(int petId) {
        return petTrackRepository.findOwnerByPetId(petId);
    }

    @Override
    public Pet findPetById(int petId) {
        return petTrackRepository.findPetById(petId);
    }

    @Override
    public List<Pet> findAllPetByOwnerId(int ownerId) {
        return petTrackRepository.findAllPetByOwnerId(ownerId);
    }

    @Override
    public List<Owner> findOwnerByDateCreated(LocalDate dateCreated) {
        return petTrackRepository.findOwnerByDateCreated(dateCreated);
    }


    @Override
    public List<Owner> findAll() {
        return petTrackRepository.findAll();
    }
}
