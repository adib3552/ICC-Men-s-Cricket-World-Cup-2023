package com.UniProject.Controller;

import com.UniProject.DTO.*;
import com.UniProject.Enteties.MatchInfo;
import com.UniProject.Enteties.Player;
import com.UniProject.Enteties.Team;
import com.UniProject.Enteties.Venue;
import com.UniProject.Services.MatchService;
import com.UniProject.Services.PlayerService;
import com.UniProject.Services.TeamService;
import com.UniProject.Services.VenueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


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

    @GetMapping("/message")
    public ResponseEntity<String>showMessage(){
        return ResponseEntity.status(HttpStatus.OK).body("This is Admin page");
    }
    @PostMapping("/player")
    public ResponseEntity<String>addPlayerInfo(@RequestBody PlayerWithoutTeamDto playerDto){
        Player player = playerService.addPlayer(playerDto);
        if(player!=null){
            return ResponseEntity.status(HttpStatus.OK).body("Saved player info");
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");
    }
    @PostMapping("/team")
    public ResponseEntity<String>addTeamInfo(@RequestBody TeamDtoWithoutPlayer team){
        Team t=teamService.saveTeam(team);
        if(t!=null){
            return ResponseEntity.status(HttpStatus.OK).body("Team info saved");
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");
    }
    @PostMapping("/match")
    public ResponseEntity<String>addMatch(@RequestBody MatchDtoForInsert matchInfo){
        MatchInfo m=matchService.addMatch(matchInfo);
        if(m!=null){
            return ResponseEntity.status(HttpStatus.OK).body("Saved successfully");
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");
    }
    @PostMapping("/venue")
    public ResponseEntity<String>saveVenue(@RequestBody VenueDto venueDto){
        Venue v=venueService.addVenue(venueDto);
        if(v!=null){
            return ResponseEntity.status(HttpStatus.OK).body("Saved Successfully");
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");
    }
    @PutMapping("/match/set-winning-team")
    public ResponseEntity<String>updateWinner(@RequestBody Match match){
        if(matchService.updateWinningTeam(match)){
            return ResponseEntity.status(HttpStatus.OK).body("Updated");
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("something went wrong");
    }
    @PutMapping("/match/set-time")
    public ResponseEntity<String>updateMatchTime(@RequestBody Match match){

        if(matchService.updateMatchTime(match)){
            return ResponseEntity.status(HttpStatus.OK).body("Updated");
        }

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");
    }
    @PutMapping("/player/update-player-name")
    public ResponseEntity<String>updatePlayer(@RequestBody PlayerDto playerDto){
        if(playerService.updatePlayerName(playerDto)){
            return ResponseEntity.status(HttpStatus.OK).body("Updated");
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");
    }
    @PutMapping("/player/update-player-run-wicket")
    public ResponseEntity<String>updatePlayerRunsWickets(@RequestBody PlayerDto playerDto){
        if(playerService.updatePlayerRunsAndWicket(playerDto)){
            return ResponseEntity.status(HttpStatus.OK).body("Updated");
        }
       return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");
    }
    @PutMapping("/player/update-player-team")
    public ResponseEntity<String>updatePlayerTeam(@RequestBody PlayerWithoutTeamDto playerDto){
        if(playerService.updatePlayerTeam(playerDto)){
            return ResponseEntity.status(HttpStatus.OK).body("Updated");
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");
    }
    @PutMapping("/player/update-player-point")
    public ResponseEntity<String>updatePlayerPoint(@RequestBody PlayerWithoutTeamDto playerDto){
        if(playerService.updatePlayerPoint(playerDto)){
            return ResponseEntity.status(HttpStatus.OK).body("Updated");
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");
    }
    @PutMapping("/team/update-team-name")
    public ResponseEntity<String>updateTeamName(@RequestBody TeamDtoWithoutPlayer team){
        if(teamService.updateTeamName(team)){
            return ResponseEntity.status(HttpStatus.OK).body("Updated");
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");
    }
    @PutMapping("/team/update-team-score")
    public ResponseEntity<String>updateTeamScore(@RequestBody TeamDto team){
        if(teamService.updateTeamScore(team)){
            return ResponseEntity.status(HttpStatus.OK).body("Updated");
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");
    }
    @PutMapping("/venue/update-venue-name")
    public ResponseEntity<String>updateVenueName(@RequestBody VenueDto venueDto){
        if(venueService.updateVenueName(venueDto)){
            return ResponseEntity.status(HttpStatus.OK).body("Updated");
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");
    }
    @PutMapping("/venue/update-venue-location")
    public ResponseEntity<String>updateVenueLocation(@RequestBody VenueDto venueDto){
        if(venueService.updateVenueLocation(venueDto)){
            return ResponseEntity.status(HttpStatus.OK).body("Updated");
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");
    }


    @DeleteMapping("/player/delete")
    public ResponseEntity<String>deletePlayer(@RequestBody PlayerDto playerDto){
        if(playerService.deletePlayer(playerDto)){
            return ResponseEntity.status(HttpStatus.OK).body("Deleted");
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");
    }
    @DeleteMapping("/team/delete")
    public ResponseEntity<String>deleteTeam(@RequestBody TeamDto teamDto){
        if(teamService.deleteTeam(teamDto)){
            return ResponseEntity.status(HttpStatus.OK).body("Deleted");
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");
    }
    @DeleteMapping("/match/delete")
    public ResponseEntity<String>deleteMatch(@RequestBody MatchDto matchDto){
        if(matchService.deleteMatch(matchDto)){
            return ResponseEntity.status(HttpStatus.OK).body("Deleted");
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");
    }
    @DeleteMapping("/venue/delete")
    public ResponseEntity<String>deleteVenue(@RequestBody VenueDto venueDto){
        if(venueService.deleteVenue(venueDto)){
            return ResponseEntity.status(HttpStatus.OK).body("Deleted");
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");
    }

}
