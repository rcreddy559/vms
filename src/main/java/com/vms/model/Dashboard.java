package com.vms.model;

import java.util.List;
import java.util.Map;

public class Dashboard {

    private long residentsCount;
    private long eventsCount;
    private Map<String, Double> donationsByEvent;
    private Event currentEvent;
    private List<Event> upcomingEvents;

    public Dashboard(Event currentEvent, Map<String, Double> donationsByEvent, long eventsCount, long residentsCount,
            List<Event> upcomingEvents) {
        this.currentEvent = currentEvent;
        this.donationsByEvent = donationsByEvent;
        this.eventsCount = eventsCount;
        this.residentsCount = residentsCount;
        this.upcomingEvents = upcomingEvents;
    }

    public Dashboard() {
    }

    public long getResidentsCount() {
        return residentsCount;
    }

    public void setResidentsCount(long residentsCount) {
        this.residentsCount = residentsCount;
    }

    public long getEventsCount() {
        return eventsCount;
    }

    public void setEventsCount(long eventsCount) {
        this.eventsCount = eventsCount;
    }

    public Map<String, Double> getDonationsByEvent() {
        return donationsByEvent;
    }

    public void setDonationsByEvent(Map<String, Double> donationsByEvent) {
        this.donationsByEvent = donationsByEvent;
    }

    public Event getCurrentEvent() {
        return currentEvent;
    }

    public void setCurrentEvent(Event currentEvent) {
        this.currentEvent = currentEvent;
    }

    public List<Event> getUpcomingEvents() {
        return upcomingEvents;
    }

    public void setUpcomingEvents(List<Event> upcomingEvents) {
        this.upcomingEvents = upcomingEvents;
    }

}
