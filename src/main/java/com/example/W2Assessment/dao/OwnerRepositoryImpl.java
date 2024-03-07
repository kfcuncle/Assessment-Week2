package com.example.W2Assessment.dao;

import com.example.W2Assessment.entity.Owner;
import com.example.W2Assessment.entity.Pet;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@Repository
public class OwnerRepositoryImpl implements OwnerRepository{
    private EntityManager entityManager;

    @Autowired
    public OwnerRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void save(Owner owner) {
        entityManager.persist(owner);
    }

    @Override
    public Owner findOwnerById(int ownerId) {
        Owner owner = entityManager.find(Owner.class,ownerId);
        return owner;
    }

    @Override
    public Owner findOwnerByPetId(int petId) {
        Pet pet = entityManager.find(Pet.class,petId);
        return pet.getOwner();
    }

    @Override
    public List<Owner> findOwnerByDateCreated(LocalDate dateCreated) {
        TypedQuery<Owner> query = entityManager.createQuery(
                "from Owner where dateCreated =: data", Owner.class);
        query.setParameter("data", dateCreated);

        // execute query
        return query.getResultList();
    }

    public List<Owner> findAll(){
        TypedQuery<Owner> query = entityManager.createQuery(
                "from Owner", Owner.class);
        // execute query
        return query.getResultList();
    }
}
