package com.UniProject.Services;

import com.UniProject.DTO.DtoImpl;
import com.UniProject.DTO.PlayerDto;
import com.UniProject.DTO.PlayerWithoutTeamDto;
import com.UniProject.Enteties.Player;
import com.UniProject.Enteties.Team;
import com.UniProject.Repository.PlayerRepository;
import com.UniProject.Repository.TeamRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PlayerService {

    @Autowired
    PlayerRepository playerRepository;

    @Autowired
    TeamRepository teamRepository;

    @Autowired
    private DtoImpl dto;

    public Player addPlayer(PlayerWithoutTeamDto playerDto){
        Player player=dto.covertPlayerDtoWithoutTeamDtoToPlayer(playerDto);
        Team team=teamRepository.findByName(playerDto.getTname());
        //System.out.println(playerDto.getTname());
        player.setTeam_name(team);
        return playerRepository.save(player);
    }

    public List<PlayerDto>getAllPlayer(){
        return dto.convertPlayerListToDto((List<Player>) playerRepository.findAll());
    }

    public PlayerDto getPlayerByName(String name){
        return dto.convertPlayerDto(playerRepository.findByName(name));
    }

    @Transactional
    public boolean updatePlayerName(PlayerDto player){
        try{
            playerRepository.updatePlayerName(player.getName(), player.getPid());
        }catch(Exception e){
            return false;
        }
        return true;
    }

    @Transactional
    public boolean updatePlayerRunsAndWicket(PlayerDto playerDto){
        try {
            playerRepository.updatePlayerRunAndWicket(playerDto.getRuns(),playerDto.getWickets(), playerDto.getPid());
        }catch(Exception e){
            return false;
        }
        return true;
    }

    @Transactional
    public boolean updatePlayerTeam(PlayerWithoutTeamDto player){
        try {
            Team team=teamRepository.findByName(player.getTname());
            playerRepository.updatePlayerTeam(player.getTname(), team, player.getPid());
        }catch(Exception e){
            return false;
        }
        return true;
    }
    @Transactional
    public boolean updatePlayerPoint(PlayerWithoutTeamDto player){
        try {
            playerRepository.updatePlayerPoints(player.getPoints(), player.getPid());
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Transactional
    public boolean deletePlayer(PlayerDto player){
        try{
            playerRepository.deleteByPid(player.getPid());
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
