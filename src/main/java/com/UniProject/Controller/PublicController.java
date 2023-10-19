package com.UniProject.Controller;

import com.UniProject.DTO.*;
import com.UniProject.ExternalApi.News;
import com.UniProject.Services.MatchService;
import com.UniProject.Services.PlayerService;
import com.UniProject.Services.TeamService;
import com.UniProject.Services.VenueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/public")
public class PublicController {

    @Autowired
    private News news;

    @Autowired
    private MatchService matchService;

    @Autowired
    private TeamService teamService;

    @Autowired
    private PlayerService playerService;

    @Autowired
    private VenueService venueService;

    @GetMapping("/news")
    public List<Story>showNews(){
        return news.getStoryList();
    }

    @GetMapping("/matches")
    public List<MatchDto>showAllMatches(){
        return matchService.getAllMatch();
    }
    @GetMapping("/teams")
    public List<TeamDto>showAllTeamName(){
        return teamService.showAllTeam();
    }
    @GetMapping("/teams/{name}")
    public TeamDto showTeamByName(@PathVariable String name){
        return teamService.getTeamInfoByName(name);
    }
    @GetMapping("/players")
    public List<PlayerDto>showAllPlayer(){
        return playerService.getAllPlayer();
    }
    @GetMapping("/players/{pname}")
    public PlayerDto showOnePlayer(@PathVariable String pname){
        return playerService.getPlayerByName(pname);
    }
    @GetMapping("/venue/{vname}")
    public VenueDto showVenueByName(@PathVariable String vname){
        return venueService.getVenueByName(vname);
    }
    @GetMapping("/scoreboard")
    public List<TeamDtoWithoutPlayer>showScoreBoard(){
        return teamService.showScoreBoard();
    }
}
