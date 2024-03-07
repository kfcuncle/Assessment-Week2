package com.example.W2Assessment.dao;

import com.example.W2Assessment.entity.Owner;
import com.example.W2Assessment.entity.Pet;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class PetTrackRepositoryImpl implements PetTrackRepository{

    private EntityManager entityManager;

    @Autowired
    public PetTrackRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void save(Owner owner) {
        entityManager.persist(owner);
    }

    @Override
    public void save(Pet pet) {
        entityManager.persist(pet);
    }

    @Override
    public void delete(int petId) {
        Pet pet = entityManager.find(Pet.class, petId);
        entityManager.remove(pet);
    }

    @Override
    public void update(Pet pet) {
        entityManager.merge(pet);
    }

    @Override
    public Owner findOwnerById(int ownerId) {
        Owner owner = entityManager.find(Owner.class,ownerId);
        return owner;
    }

    @Override
    public Pet findPetById(int petId) {
        Pet pet = entityManager.find(Pet.class,petId);
        return pet;
    }

    @Override
    public Owner findOwnerByPetId(int petId) {
        Pet pet = entityManager.find(Pet.class,petId);
        return pet.getOwner();
    }

    @Override
    public List<Pet> findAllPetByOwnerId(int ownerId) {
        TypedQuery<Pet> query = entityManager.createQuery(
                "from Pet where owner.id = :data", Pet.class);
        query.setParameter("data", ownerId);

        // execute query
        List<Pet> pets = query.getResultList();
        return pets;
    }

    @Override
    public List<Owner> findOwnerByDateCreated(LocalDate dateCreated) {
        TypedQuery<Owner> query = entityManager.createQuery(
                "from Owner where dateCreated =: data", Owner.class);
        query.setParameter("data", dateCreated);

        // execute query
        List<Owner> owners = query.getResultList();
        return owners;
    }

    public List<Owner> findAll(){
        TypedQuery<Owner> query = entityManager.createQuery(
                "from Owner", Owner.class);
        // execute query
        List<Owner> owners = query.getResultList();
        return owners;
    }
}
