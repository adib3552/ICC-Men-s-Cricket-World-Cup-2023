package com.UniProject.Controller;

import com.UniProject.Enteties.MatchInfo;
import com.UniProject.Enteties.Player;
import com.UniProject.Enteties.Team;
import com.UniProject.Enteties.Venue;
import com.UniProject.DTO.MatchDto;
import com.UniProject.Services.MatchService;
import com.UniProject.Services.PlayerService;
import com.UniProject.Services.TeamService;
import com.UniProject.Services.VenueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    PlayerService playerService;

    @Autowired
    TeamService teamService;

    @Autowired
    MatchService matchService;

    @Autowired
    VenueService venueService;

    @PostMapping("/player")
    public ResponseEntity<String>addPlayerInfo(@RequestBody Player player){
        Team t=teamService.showTeamInfoByName(player.getTname());
        player.setTeam_name(t);
        Player p=playerService.addPlayer(player);
        if(p!=null){
            return ResponseEntity.status(HttpStatus.OK).body("Saved player info");
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");
    }
    @PostMapping("/team")
    public ResponseEntity<String>addTeamInfo(@RequestBody Team team){
        Team t=teamService.saveTeam(team);
        if(t!=null){
            return ResponseEntity.status(HttpStatus.OK).body("Team info saved");
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");
    }
    @PostMapping("/match")
    public ResponseEntity<String>addMatch(@RequestBody MatchDto match){
        Team t1=teamService.showTeamInfoByName(match.getTeam1());
        Team t2=teamService.showTeamInfoByName(match.getTeam2());
        Venue v=venueService.showVenueByName(match.getVname());
        List<Team>teams=new ArrayList<>();
        teams.add(t1);
        teams.add(t2);
        MatchInfo matchInfo=match.getMatchInfo();
        matchInfo.setTeamsPlaying(teams);
        matchInfo.setVenue(v);
        MatchInfo m=matchService.addMatch(matchInfo);
        if(m!=null){
            return ResponseEntity.status(HttpStatus.OK).body("Saved successfully");
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");
    }
    @PostMapping("/venue")
    public ResponseEntity<String>saveVenue(@RequestBody Venue venue){
        Venue v=venueService.addVenue(venue);
        if(v!=null){
            return ResponseEntity.status(HttpStatus.OK).body("Saved Successfully");
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");
    }
}
