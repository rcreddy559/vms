package com.vms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vms.model.Donation;

@Repository
public interface DonationRepository extends JpaRepository<Donation, Long> {
}
