package com.vms.service.impl;

import com.vms.dto.ResidentDto;
import com.vms.model.Resident;
import com.vms.repository.ResidentRepository;
import com.vms.service.ResidentService;
import org.modelmapper.ModelMapper;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ResidentServiceImpl implements ResidentService {

    private final ResidentRepository repository;
    private final ModelMapper modelMapper;

    public ResidentServiceImpl(ResidentRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    @Override
    @Cacheable("residents")
    public List<ResidentDto> getAll() {
        var residents = repository.findAll();
        return residents.stream().map(r -> modelMapper.map(r, ResidentDto.class)).collect(Collectors.toList());
    }

    @Override
    public ResidentDto getById(Long id) {
        var resident = repository.findById(id).orElseThrow();
        return modelMapper.map(resident, ResidentDto.class);
    }

    @Override
    public ResidentDto create(ResidentDto resident) {
        Resident residentEntity = modelMapper.map(resident, Resident.class);
        var dbResident = repository.save(residentEntity);
        return modelMapper.map(dbResident, ResidentDto.class);
    }

    @Override
    public ResidentDto update(Long id, ResidentDto updated) {
        Resident existing = repository.findById(id).orElseThrow();
        existing.setName(updated.getName());
        existing.setDateOfBirth(updated.getDateOfBirth());
        existing.setAddress(updated.getAddress());
        existing.setPhoneNumber(updated.getPhoneNumber());
        existing.setEmailId(updated.getEmailId());
        var dbResident = repository.save(existing);
        return modelMapper.map(dbResident, ResidentDto.class);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Map<String, List<ResidentDto>> getByRole() {
        List<ResidentDto> residentList = getAll();
        return residentList.stream()
                .collect(Collectors.groupingBy(ResidentDto::getRole, Collectors.toList()));
    }

    @Override
    public Map<String, List<ResidentDto>> getByRole(String role) {
        Map<String, List<Resident>> byRole = new HashMap<>();
        byRole.put(role, repository.findByRole(role));
        return byRole.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey,
                        entry -> entry.getValue().stream()
                                .map(r -> modelMapper.map(r, ResidentDto.class))
                                .collect(Collectors.toList())));
    }

    @Override
    public void validatePhoneNumber(String phoneNumber) {
        this.repository.findByPhoneNumber(phoneNumber);
    }
}
