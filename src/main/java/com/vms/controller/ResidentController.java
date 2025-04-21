package com.vms.controller;

import org.springframework.web.bind.annotation.*;

import com.vms.model.Resident;
import com.vms.service.ResidentService;

import java.util.List;

@RestController
@RequestMapping("/residents")
public class ResidentController {

    public ResidentController(ResidentService residentService) {
        this.residentService = residentService;
    }

    private final ResidentService residentService;

    @GetMapping
    public List<Resident> getAllResidents() {
        return residentService.getAll();
    }

    @GetMapping("/{id}")
    public Resident getResidentById(@PathVariable Long id) {
        return residentService.getById(id);
    }

    @PostMapping
    public Resident createResident(@RequestBody Resident resident) {
        return residentService.create(resident);
    }

    @PutMapping("/{id}")
    public Resident updateResident(@PathVariable Long id, @RequestBody Resident resident) {
        return residentService.update(id, resident);
    }

    @DeleteMapping("/{id}")
    public void deleteResident(@PathVariable Long id) {
        residentService.delete(id);
    }
}
