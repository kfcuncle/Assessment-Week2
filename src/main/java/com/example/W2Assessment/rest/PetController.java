package com.example.W2Assessment.rest;

import com.example.W2Assessment.entity.Pet;
import com.example.W2Assessment.service.PetService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pet")
public class PetController {
    private PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    @PostMapping("/{ownerId}")
    public ResponseEntity save(@RequestBody Pet pet, @PathVariable Integer ownerId) {
        petService.save(pet, ownerId);
        return new ResponseEntity("Save Pet Name : " + pet.getName(), HttpStatus.OK);
    }

    @DeleteMapping("/{petId}")
    public ResponseEntity deletePet(@PathVariable Integer petId) {
        petService.delete(petId);
        return new ResponseEntity("Deleted Pet Id: " + petId, HttpStatus.OK);
    }

    @PutMapping("")
    public ResponseEntity updatePet(@RequestBody Pet pet) {
        petService.update(pet);
        return new ResponseEntity(pet.toString(), HttpStatus.OK);
    }

    @GetMapping("/pets/{ownerId}")
    public ResponseEntity findAllPetByOwnerId(@PathVariable Integer ownerId) {
        return new ResponseEntity(petService.findAllPetByOwnerId(ownerId).toString(), HttpStatus.OK);
    }

}
