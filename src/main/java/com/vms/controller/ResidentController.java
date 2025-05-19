package com.vms.controller;

import com.vms.dto.ResidentDto;
import com.vms.service.ResidentService;
import org.springframework.web.bind.annotation.*;

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
    public List<ResidentDto> getAllResidents() {
        return residentService.getAll();
    }

    @GetMapping("/{id}")
    public ResidentDto getResidentById(@PathVariable Long id) {
        return residentService.getById(id);
    }

    @GetMapping("/role")
    public Map<String, List<ResidentDto>> getByRole() {
        return residentService.getByRole();
    }

    @GetMapping("/role/{role}")
    public Map<String, List<ResidentDto>> getByRole(@PathVariable String role) {

        return residentService.getByRole(role);
    }

    @PostMapping
    public ResidentDto createResident(@RequestBody ResidentDto resident) {
        return residentService.create(resident);
    }

    @PutMapping("/{id}")
    public ResidentDto updateResident(@PathVariable Long id, @RequestBody ResidentDto resident) {
        return residentService.update(id, resident);
    }

    @DeleteMapping("/{id}")
    public void deleteResident(@PathVariable Long id) {
        residentService.delete(id);
    }
}
