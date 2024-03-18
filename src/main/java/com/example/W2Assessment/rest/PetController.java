package com.example.W2Assessment.rest;

import com.example.W2Assessment.entity.Pet;
import com.example.W2Assessment.service.PetService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/pet")
public class PetController {
    private PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    @PostMapping("/{ownerId}")
    public ResponseEntity<Void> save(@RequestBody Pet pet, @PathVariable Integer ownerId) {
        petService.save(pet, ownerId);
        return new ResponseEntity<>(null,HttpStatus.OK);
    }

    @DeleteMapping("/{petId}")
    public ResponseEntity<Void> deletePet(@PathVariable Integer petId) {
        petService.delete(petId);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @PutMapping("")
    public ResponseEntity<Void> updatePet(@RequestBody Pet pet) {
        petService.update(pet);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @GetMapping("/pets/{ownerId}")
    public ResponseEntity<List<Pet>> findAllPetByOwnerId(@PathVariable Integer ownerId) {
        return new ResponseEntity<List<Pet>>(petService.findAllPetByOwnerId(ownerId), HttpStatus.OK);
    }

}
