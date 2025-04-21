package com.vms.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String location;

    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "organizer_id")
    private Resident organizer;

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Donation> donations;

    public Event(LocalDate date, List<Donation> donations, Long id, String location, String name, Resident organizer) {
        this.date = date;
        this.donations = donations;
        this.id = id;
        this.location = location;
        this.name = name;
        this.organizer = organizer;
    }

    public Event() {
    }

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Resident getOrganizer() {
        return organizer;
    }

    public void setOrganizer(Resident organizer) {
        this.organizer = organizer;
    }

    public List<Donation> getDonations() {
        return donations;
    }

    public void setDonations(List<Donation> donations) {
        this.donations = donations;
    }

    
}
