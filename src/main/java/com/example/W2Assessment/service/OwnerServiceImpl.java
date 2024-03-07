package com.example.W2Assessment.service;

import com.example.W2Assessment.dao.OwnerRepository;
import com.example.W2Assessment.entity.Owner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class OwnerServiceImpl implements OwnerService{
    private OwnerRepository ownerRepository;

    public OwnerServiceImpl(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @Override
    @Transactional
    public void save(Owner owner) {
        owner.setDateCreated(LocalDate.now());
        owner.setDateModified(LocalDate.now());
        ownerRepository.save(owner);
    }


    @Override
    public Owner findOwnerByPetId(Integer petId) {
        return ownerRepository.findOwnerByPetId(petId);
    }

    @Override
    public List<Owner> findOwnerByDateCreated(LocalDate dateCreated) {
        return ownerRepository.findOwnerByDateCreated(dateCreated);
    }

    @Override
    public List<Owner> findAll() {
        return ownerRepository.findAll();
    }
}
