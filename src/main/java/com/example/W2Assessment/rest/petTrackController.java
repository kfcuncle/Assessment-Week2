package com.example.W2Assessment.rest;

import com.example.W2Assessment.entity.Owner;
import com.example.W2Assessment.entity.Pet;
import com.example.W2Assessment.service.PetTrackService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/petTrack")
public class petTrackController {
    private PetTrackService petTrackService;

    public petTrackController(PetTrackService petTrackService) {
        this.petTrackService = petTrackService;
    }

    @PostMapping("/saveOwner")
    public String save(@RequestBody Owner owner){
        petTrackService.save(owner);
        return "Save Owner Name : " + owner.getFirstName();
    }

    @PostMapping("/savePet/{ownerId}")
    public String save(@RequestBody Pet pet, @PathVariable int ownerId){
        petTrackService.save(pet,ownerId);
        return "Save Pet Name : " + pet.getName();
    }

    @GetMapping("/getOwners")
    public String findAllOwners(){
        List<Owner> owners = petTrackService.findAll();
        return owners.toString();
    }

    @DeleteMapping("/deletePet/{petId}")
    public String deletePet(@PathVariable int petId){
        petTrackService.delete(petId);
        return "Deleted Pet Id: " + petId;
    }

    @PutMapping("/updatePet")
    public String updatePet(@RequestBody Pet pet){
        petTrackService.update(pet);
        return pet.toString();
    }

    @GetMapping("/getOwnerByPetId/{petId}")
    public String findOwnerByPetId(@PathVariable int petId){
        return petTrackService.findOwnerByPetId(petId).toString();
    }

    @GetMapping("/getAllPetByOwnerId/{ownerId}")
    public String findAllPetByOwnerId(@PathVariable int ownerId){
        return petTrackService.findAllPetByOwnerId(ownerId).toString();
    }

    @GetMapping("/getOwnerByDateCreated/{dateCreated}")
    public String findOwnerByDateCreated(@PathVariable LocalDate dateCreated){
        return petTrackService.findOwnerByDateCreated(dateCreated).toString();
    }
}
