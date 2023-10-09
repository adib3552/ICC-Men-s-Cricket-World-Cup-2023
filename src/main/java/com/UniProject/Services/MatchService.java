package com.UniProject.Services;

import com.UniProject.DTO.*;
import com.UniProject.Enteties.MatchInfo;
import com.UniProject.Enteties.Player;
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

    @Autowired
    private DtoImpl dto;

    public MatchInfo addMatch(MatchInfo matchInfo){
        return matchRepository.save(matchInfo);
    }
    public List<MatchDto> getAllMatch(){
        List<MatchInfo>matches = (List<MatchInfo>) matchRepository.findAll();
        return dto.convertMatchListToDto(matches);
    }

}
