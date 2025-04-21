package com.vms.model;

import jakarta.persistence.*;

@Entity
public class Donation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "resident_id")
    private Resident resident;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "event_id")
    private Event event;

    private double amount;

    @Enumerated(EnumType.STRING)
    private DonationStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "created_by_id")
    private Resident createdBy;

    public Donation(double amount, Resident createdBy, Event event, Long id, Resident resident, DonationStatus status) {
        this.amount = amount;
        this.createdBy = createdBy;
        this.event = event;
        this.id = id;
        this.resident = resident;
        this.status = status;
    }

    public Donation() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Resident getResident() {
        return resident;
    }

    public void setResident(Resident resident) {
        this.resident = resident;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public DonationStatus getStatus() {
        return status;
    }

    public void setStatus(DonationStatus status) {
        this.status = status;
    }

    public Resident getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Resident createdBy) {
        this.createdBy = createdBy;
    }

}
