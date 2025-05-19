package com.vms.model;

import jakarta.persistence.*;

@Entity
public class Donation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "seq_resident_id")
    @SequenceGenerator(name = "seq_resident_id", sequenceName = "seq_resident_id", allocationSize = 1)
    @Column(name = "id")
    private Long id;
    private Long residentId;
    private Long eventId;
    private double amount;
    private double createdById;

    @Enumerated(EnumType.STRING)
    private DonationStatus status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getResidentId() {
        return residentId;
    }
    public void setResidentId(Long residentId) {
        this.residentId = residentId;
    }
    public Long getEventId() {
        return eventId;
    }
    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }
    public double getCreatedById() {
        return createdById;
    }
    public void setCreatedById(double createdById) {
        this.createdById = createdById;
    }
}
