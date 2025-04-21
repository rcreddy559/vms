package com.vms.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.vms.model.Donation;
import com.vms.repository.DonationRepository;
import com.vms.service.DonationService;

import java.util.List;

@Service
public class DonationServiceImpl implements DonationService {

    private final DonationRepository repository;

    public DonationServiceImpl(DonationRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Donation> getAll() {
        return repository.findAll();
    }

    @Override
    public Donation getById(Long id) {
        return repository.findById(id).orElseThrow();
    }

    @Override
    public Donation create(Donation donation) {
        return repository.save(donation);
    }

    @Override
    public Donation update(Long id, Donation updated) {
        Donation donation = getById(id);
        donation.setAmount(updated.getAmount());
        donation.setStatus(updated.getStatus());
        donation.setEvent(updated.getEvent());
        donation.setResident(updated.getResident());
        return repository.save(donation);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
