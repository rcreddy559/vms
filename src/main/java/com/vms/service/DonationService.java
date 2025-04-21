package com.vms.service;

import java.util.List;

import com.vms.model.Donation;

public interface DonationService {
    List<Donation> getAll();

    Donation getById(Long id);

    Donation create(Donation donation);

    Donation update(Long id, Donation donation);

    void delete(Long id);
}
