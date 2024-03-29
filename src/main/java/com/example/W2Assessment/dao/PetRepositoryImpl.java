package com.example.W2Assessment.dao;

import com.example.W2Assessment.entity.Pet;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PetRepositoryImpl implements PetRepository {
    private EntityManager entityManager;

    @Autowired
    public PetRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void save(Pet pet) {
        entityManager.persist(pet);
    }

    @Override
    public void delete(Integer petId) {
        Pet pet = entityManager.find(Pet.class, petId);
        entityManager.remove(pet);
    }

    @Override
    public void update(Pet pet) {
        entityManager.merge(pet);
    }

    @Override
    public Pet findPetById(Integer petId) {
        Pet pet = entityManager.find(Pet.class, petId);
        return pet;
    }

    @Override
    public List<Pet> findAllPetByOwnerId(Integer ownerId) {
        TypedQuery<Pet> query = entityManager.createQuery(
                "from Pet where owner.id = :data", Pet.class);
        query.setParameter("data", ownerId);

        // execute query
        return query.getResultList();
    }
}
