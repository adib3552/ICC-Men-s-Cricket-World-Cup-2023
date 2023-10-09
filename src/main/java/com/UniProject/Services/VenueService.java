package com.UniProject.Services;

import com.UniProject.DTO.DtoImpl;
import com.UniProject.DTO.VenueDto;
import com.UniProject.Enteties.Venue;
import com.UniProject.Repository.VenueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VenueService {
    @Autowired
    VenueRepository venueRepository;

    @Autowired
    DtoImpl dto;
    public Venue showVenueByName(String name){
        return venueRepository.findByName(name);
    }
    public Venue addVenue(Venue venue){
        return venueRepository.save(venue);
    }

    public VenueDto getVenueByName(String name){
        return dto.convertVenueToDto(venueRepository.findByName(name));
    }
}
