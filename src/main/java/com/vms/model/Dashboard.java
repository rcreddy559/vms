package com.vms.model;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Dashboard {
    private long residentsCount;
    private long eventsCount;
    private Map<String, Double> donationsByEvent;
    private Event currentEvent;
    private List<Event> upcomingEvents;
}
