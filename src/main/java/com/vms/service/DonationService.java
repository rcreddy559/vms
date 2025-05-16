package com.vms.service;

import java.util.List;

import com.vms.dto.DonationDto;
import com.vms.model.Donation;

public interface DonationService {
    List<DonationDto> getAll();

    Donation getById(Long id);

    Donation create(Donation donation);

    Donation update(Long id, Donation donation);

    void delete(Long id);
}
