package com.UniProject.Services;

import com.UniProject.DTO.MatchDto;
import com.UniProject.DTO.TeamDto;
import com.UniProject.DTO.VenueDto;
import com.UniProject.Enteties.MatchInfo;
import com.UniProject.Enteties.Team;
import com.UniProject.Enteties.Venue;
import com.UniProject.Repository.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MatchService {

    @Autowired
    private MatchRepository matchRepository;

    public MatchInfo addMatch(MatchInfo matchInfo){
        return matchRepository.save(matchInfo);
    }
    public List<MatchDto> getAllMatch(){
        List<MatchInfo>matches= (List<MatchInfo>) matchRepository.findAll();
        return convertDtoToMatch(matches);
    }
    public List<MatchDto>convertDtoToMatch(List<MatchInfo> matches){
        List<MatchDto>matchDtoList=new ArrayList<>();
        for (MatchInfo m:matches){
            MatchDto matchDto1=new MatchDto();
            matchDto1.setM_id(m.getM_id());
            matchDto1.setMatch_date_time(m.getMatch_date_time());
            matchDto1.setWinning_team(m.getWinning_team());
            matchDto1.setWinning_team(m.getVname());

            matchDto1.setTeamsPlaying(convertDtoToTeam(m.getTeamsPlaying()));
            matchDto1.setVenue(convertDtoToVenue(m.getVenue()));

            matchDtoList.add(matchDto1);
        }
        return matchDtoList;
    }

    public List<TeamDto>convertDtoToTeam(List<Team> teams){
        List<TeamDto>teamDtoList=new ArrayList<>();

        for(Team team:teams){
            TeamDto teamDto=new TeamDto();
            teamDto.setTid(team.getTid());
            teamDto.setName(team.getName());

            teamDtoList.add(teamDto);
        }

        return teamDtoList;
    }

    public VenueDto convertDtoToVenue(Venue venue){
        VenueDto venueDto=new VenueDto();
        venueDto.setVid(venue.getVid());
        venueDto.setName(venue.getName());
        venueDto.setStadium(venue.getStadium());

        return venueDto;
    }
}
