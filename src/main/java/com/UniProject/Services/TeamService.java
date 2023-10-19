package com.UniProject.Services;

import com.UniProject.DTO.DtoImpl;
import com.UniProject.DTO.TeamDto;
import com.UniProject.DTO.TeamDtoWithoutPlayer;
import com.UniProject.Enteties.Team;
import com.UniProject.Repository.TeamRepository;
import jakarta.transaction.Transactional;
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

    public Team saveTeam(TeamDtoWithoutPlayer teamDto){
        return teamRepository.save(dto.convertTeamDtoWithoutPlayerToTeam(teamDto));
    }

    @Transactional
    public boolean updateTeamName(TeamDtoWithoutPlayer team){
        try{
            teamRepository.updateTeamName(team.getName(), team.getTid());
        }catch(Exception e){
            return false;
        }
        return true;
    }
    @Transactional
    public boolean updateTeamScore(TeamDto team){
        try{
            teamRepository.updateTeamScore(team.getScore(), team.getTid());
        }catch(Exception e){
            return false;
        }
        return true;
    }

    @Transactional
    public boolean deleteTeam(TeamDto team){
        try{
            teamRepository.deleteByTid(team.getTid());
        }catch(Exception e){
            return false;
        }
        return true;
    }
}
