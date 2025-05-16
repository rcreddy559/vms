package com.vms.controller;

import org.springframework.web.bind.annotation.*;

import com.vms.dto.DonationDto;
import com.vms.model.Donation;
import com.vms.service.DonationService;

import java.util.List;

@RestController
@RequestMapping("/vms/api/v1/donations")
public class DonationController {

    private final DonationService donationService;

    public DonationController(DonationService donationService) {
        this.donationService = donationService;
    }

    @GetMapping
    public List<DonationDto> getAllDonations() {
        return donationService.getAll();
    }

    @GetMapping("/{id}")
    public Donation getDonationById(@PathVariable Long id) {
        return donationService.getById(id);
    }

    @PostMapping
    public Donation createDonation(@RequestBody Donation donation) {
        return donationService.create(donation);
    }

    @PutMapping("/{id}")
    public Donation updateDonation(@PathVariable Long id, @RequestBody Donation donation) {
        return donationService.update(id, donation);
    }

    @DeleteMapping("/{id}")
    public void deleteDonation(@PathVariable Long id) {
        donationService.delete(id);
    }
}
