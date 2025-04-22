package com.vms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vms.model.Resident;

@Repository
public interface ResidentRepository extends JpaRepository<Resident, Long> {
    List<Resident> findByRole(String role);
}
