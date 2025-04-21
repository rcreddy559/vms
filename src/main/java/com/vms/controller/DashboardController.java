package com.vms.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vms.model.Dashboard;
import com.vms.service.DashboardService;

@RestController
@RequestMapping("/rms/v1/dashboard")
public class DashboardController {

    private final DashboardService dashboardService;

    public DashboardController(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }

    @GetMapping
    public Dashboard getDashboardStats() {
        return dashboardService.getDashboardData();
    }
}
