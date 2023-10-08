package com.UniProject.Services;

import com.UniProject.Enteties.Venue;
import com.UniProject.Repository.VenueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VenueService {
    @Autowired
    VenueRepository venueRepository;
    public Venue showVenueByName(String name){
        return venueRepository.findByName(name);
    }
    public Venue addVenue(Venue venue){
        return venueRepository.save(venue);
    }
}
