package com.UniProject.Services;

import com.UniProject.DTO.DtoImpl;
import com.UniProject.DTO.PlayerDto;
import com.UniProject.Enteties.Player;
import com.UniProject.Repository.PlayerRepository;
import com.UniProject.Repository.TeamRepository;
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

    public Player addPlayer(Player player){
        return playerRepository.save(player);
    }

    public List<PlayerDto>getAllPlayer(){
        return dto.convertPlayerListToDto((List<Player>) playerRepository.findAll());
    }

    public PlayerDto getPlayerByName(String name){
        return dto.convertPlayerDto(playerRepository.findByName(name));
    }
}
