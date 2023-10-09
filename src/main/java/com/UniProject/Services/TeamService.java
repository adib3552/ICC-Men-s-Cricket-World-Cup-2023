package com.UniProject.Services;

import com.UniProject.DTO.DtoImpl;
import com.UniProject.DTO.TeamDto;
import com.UniProject.Enteties.Team;
import com.UniProject.Repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TeamService {

    @Autowired
    public TeamRepository teamRepository;

    @Autowired
    DtoImpl dto;

    public List<TeamDto>showAllTeam(){
        return dto.convertTeamListToDto((List<Team>) teamRepository.findAll());
    }
    public TeamDto getTeamInfoByName(String name){
        return dto.convertTeamToDto(teamRepository.findByName(name));
    }
    public Team showTeamInfoByName(String name){
        return teamRepository.findByName(name);
    }

    public Team saveTeam(Team team){
        return teamRepository.save(team);
    }
}
