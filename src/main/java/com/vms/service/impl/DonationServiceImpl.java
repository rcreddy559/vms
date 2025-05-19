package com.vms.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.vms.dto.DonationDto;
import com.vms.model.Donation;
import com.vms.repository.DonationRepository;
import com.vms.service.DonationService;

import java.util.List;

@Service
public class DonationServiceImpl implements DonationService {

    private final DonationRepository repository;
    private final ModelMapper modelMapper;

    public DonationServiceImpl(DonationRepository repository,  ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        this.repository = repository;
    }

    @Override
    public List<DonationDto> getAll() {
        var donations = repository.findAll();
        var  dtos  = donations.stream().map(d-> modelMapper.map(d, DonationDto.class)).toList();
        return dtos;
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
        return repository.save(donation);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
