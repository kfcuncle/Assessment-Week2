package com.example.W2Assessment.rest;

import com.example.W2Assessment.entity.Owner;
import com.example.W2Assessment.service.OwnerService;
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
    public String save(@RequestBody Owner owner) {
        ownerService.save(owner);
        return "Save Owner Name : " + owner.getFirstName();
    }

    @GetMapping("")
    public String findAllOwners() {
        List<Owner> owners = ownerService.findAll();
        return owners.toString();
    }

    @GetMapping("pet/{petId}")
    public String findOwnerByPetId(@PathVariable Integer petId) {
        return ownerService.findOwnerByPetId(petId).toString();
    }

    @GetMapping("dateCreated/{dateCreated}")
    public String findOwnerByDateCreated(@PathVariable LocalDate dateCreated) {
        return ownerService.findOwnerByDateCreated(dateCreated).toString();
    }
}
