package com.vms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vms.model.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
}
