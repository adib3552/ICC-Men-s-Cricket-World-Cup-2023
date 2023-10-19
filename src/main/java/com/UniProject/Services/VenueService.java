package com.UniProject.Services;

import com.UniProject.DTO.DtoImpl;
import com.UniProject.DTO.VenueDto;
import com.UniProject.Enteties.Venue;
import com.UniProject.Repository.VenueRepository;
import jakarta.transaction.Transactional;
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
    public Venue addVenue(VenueDto venueDto){
        return venueRepository.save(dto.covertVenueDtoToVenue(venueDto));
    }
    public VenueDto getVenueByName(String name){
        return dto.convertVenueToDto(venueRepository.findByName(name));
    }

    @Transactional
    public boolean updateVenueName(VenueDto venueDto){
        try{
            venueRepository.updateVenueName(venueDto.getName(), venueDto.getVid());
        }catch(Exception e){
            return false;
        }
        return true;
    }
    @Transactional
    public boolean updateVenueLocation(VenueDto venueDto){
        try{
            venueRepository.updateVenueLocation(venueDto.getLocation(), venueDto.getVid());
        }catch(Exception e){
            return false;
        }
        return true;
    }

    @Transactional
    public boolean deleteVenue(VenueDto venue){
        try{
            venueRepository.deleteByVid(venue.getVid());
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
