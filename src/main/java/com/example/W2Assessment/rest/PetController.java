package com.example.W2Assessment.rest;

import com.example.W2Assessment.entity.Pet;
import com.example.W2Assessment.service.PetService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pet")
public class PetController {
    private PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    @PostMapping("/{ownerId}")
    public String save(@RequestBody Pet pet, @PathVariable Integer ownerId) {
        petService.save(pet, ownerId);
        return "Save Pet Name : " + pet.getName();
    }

    @DeleteMapping("/{petId}")
    public String deletePet(@PathVariable Integer petId) {
        petService.delete(petId);
        return "Deleted Pet Id: " + petId;
    }

    @PutMapping("")
    public String updatePet(@RequestBody Pet pet) {
        petService.update(pet);
        return pet.toString();
    }

    @GetMapping("/pets/{ownerId}")
    public String findAllPetByOwnerId(@PathVariable Integer ownerId) {
        return petService.findAllPetByOwnerId(ownerId).toString();
    }

}
