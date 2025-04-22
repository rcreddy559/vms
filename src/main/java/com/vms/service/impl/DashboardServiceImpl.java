package com.vms.service.impl;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.vms.model.Dashboard;
import com.vms.model.Donation;
import com.vms.repository.DonationRepository;
import com.vms.repository.EventRepository;
import com.vms.repository.ResidentRepository;
import com.vms.service.DashboardService;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class DashboardServiceImpl implements DashboardService {

    private final ResidentRepository residentRepo;
    private final EventRepository eventRepo;
    private final DonationRepository donationRepo;

    public DashboardServiceImpl(ResidentRepository residentRepo, EventRepository eventRepo,
            DonationRepository donationRepo) {
        this.residentRepo = residentRepo;
        this.eventRepo = eventRepo;
        this.donationRepo = donationRepo;
    }

    @Override
    @Cacheable("dashboard")
    public Dashboard getDashboardData() {

        // Group donations by event
        List<Donation> allDonations = donationRepo.findAll();
        Map<String, Double> donationMap = allDonations.stream()
                .collect(Collectors.groupingBy(
                        d -> d.getEvent().getName(),
                        Collectors.summingDouble(d -> d.getAmount())));

        for (Map.Entry<String, Double> e : donationMap.entrySet()) {
            System.out.println("Key: " + e.getKey());
            System.out.println("Value: " + e.getValue());
        }

        var dashboard = new Dashboard();
        dashboard.setCurrentEvent(null);
        dashboard.setEventsCount(20);
        dashboard.setResidentsCount(200);
        return dashboard;
    }
}
