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
        var dashboard = new Dashboard();
        dashboard.setCurrentEvent(null);
        dashboard.setEventsCount(20);
        dashboard.setResidentsCount(200);
        return dashboard;
    }
}
