package com.vms.controller;

import org.springframework.web.bind.annotation.*;

import com.vms.model.Resident;
import com.vms.service.ResidentService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/vms/api/v1/resident")
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

    @GetMapping("/role")
    public Map<String, List<Resident>> getByRole() {
        return residentService.getByRole();
    }

    @GetMapping("/role/{role}")
    public Map<String, List<Resident>> getByRole(@PathVariable String role) {

        return residentService.getByRole(role);
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
