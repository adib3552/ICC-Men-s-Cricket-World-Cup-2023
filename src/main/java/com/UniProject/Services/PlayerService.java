package com.UniProject.Services;

import com.UniProject.Enteties.Player;
import com.UniProject.Repository.PlayerRepository;
import com.UniProject.Repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PlayerService {

    @Autowired
    PlayerRepository playerRepository;

    @Autowired
    TeamRepository teamRepository;

    public Player addPlayer(Player player){
        return playerRepository.save(player);
    }
}
