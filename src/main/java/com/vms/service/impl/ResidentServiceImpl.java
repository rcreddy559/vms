package com.vms.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.vms.model.Resident;
import com.vms.repository.ResidentRepository;
import com.vms.service.ResidentService;

import java.util.List;

@Service
public class ResidentServiceImpl implements ResidentService {

    private final ResidentRepository repository;

    public ResidentServiceImpl(ResidentRepository repository) {
        this.repository = repository;
    }

    @Override
    @Cacheable("residents")
    public List<Resident> getAll() {
        return repository.findAll();
    }

    @Override
    public Resident getById(Long id) {
        return repository.findById(id).orElseThrow();
    }

    @Override
    public Resident create(Resident resident) {
        return repository.save(resident);
    }

    @Override
    public Resident update(Long id, Resident updated) {
        Resident existing = getById(id);
        existing.setName(updated.getName());
        existing.setDateOfBirth(updated.getDateOfBirth());
        existing.setAddress(updated.getAddress());
        existing.setPhoneNumber(updated.getPhoneNumber());
        existing.setEmailId(updated.getEmailId());
        return repository.save(existing);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
