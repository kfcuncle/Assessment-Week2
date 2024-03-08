package com.example.W2Assessment.rest;

import com.example.W2Assessment.entity.Owner;
import com.example.W2Assessment.service.OwnerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/owner")
public class OwnerController {

    private OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @PostMapping("")
    public ResponseEntity save(@RequestBody Owner owner) {
        ownerService.save(owner);
        return new ResponseEntity("Save Owner Name : " + owner.getFirstName(), HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity findAllOwners() {
        List<Owner> owners = ownerService.findAll();
        return new ResponseEntity(owners.toString(), HttpStatus.OK);
    }

    @GetMapping("pet/{petId}")
    public ResponseEntity findOwnerByPetId(@PathVariable Integer petId) {
        return new ResponseEntity(ownerService.findOwnerByPetId(petId).toString(), HttpStatus.OK);
    }

    @GetMapping("dateCreated/{dateCreated}")
    public ResponseEntity findOwnerByDateCreated(@PathVariable LocalDate dateCreated) {
        return new ResponseEntity(ownerService.findOwnerByDateCreated(dateCreated).toString(), HttpStatus.OK);
    }
}
