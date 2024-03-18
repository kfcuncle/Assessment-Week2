package com.example.W2Assessment.rest;

import com.example.W2Assessment.entity.Owner;
import com.example.W2Assessment.service.OwnerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/owner")
public class OwnerController {

    private OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @PostMapping("")
    public ResponseEntity<String> save(@RequestBody Owner owner) {
        ownerService.save(owner);
        return new ResponseEntity<String>("Save Owner Name : " + owner.getFirstName(), HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<Owner>> findAllOwners() {
        List<Owner> owners = ownerService.findAll();
        return new ResponseEntity<List<Owner>>(owners, HttpStatus.OK);
    }

    @GetMapping("pet/{petId}")
    public ResponseEntity<Owner> findOwnerByPetId(@PathVariable Integer petId) {
        return new ResponseEntity<Owner>(ownerService.findOwnerByPetId(petId), HttpStatus.OK);
    }

    @GetMapping("dateCreated/{dateCreated}")
    public ResponseEntity<List<Owner>> findOwnerByDateCreated(@PathVariable LocalDate dateCreated) {
        return new ResponseEntity<List<Owner>>(ownerService.findOwnerByDateCreated(dateCreated), HttpStatus.OK);
    }
}
