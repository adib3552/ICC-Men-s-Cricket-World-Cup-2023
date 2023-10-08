package com.UniProject.Services;

import com.UniProject.Enteties.Team;
import com.UniProject.Repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TeamService {

    @Autowired
    public TeamRepository teamRepository;

    public List<String>showAllTeamName(){
        return teamRepository.getAllTeamName();
    }

    public Team showTeamInfoByName(String name){
        return teamRepository.findByName(name);
    }

    public Team saveTeam(Team team){
        return teamRepository.save(team);
    }
}
