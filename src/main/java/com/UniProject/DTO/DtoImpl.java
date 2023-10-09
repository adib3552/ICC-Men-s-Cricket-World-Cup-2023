package com.UniProject.DTO;

import com.UniProject.Enteties.MatchInfo;
import com.UniProject.Enteties.Player;
import com.UniProject.Enteties.Team;
import com.UniProject.Enteties.Venue;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DtoImpl {
    public List<MatchDto> convertMatchListToDto(List<MatchInfo> matches){
        List<MatchDto>matchDtoList=new ArrayList<>();
        for (MatchInfo m:matches){
            MatchDto matchDto1=new MatchDto();
            matchDto1.setM_id(m.getM_id());
            matchDto1.setMatch_date_time(m.getMatch_date_time());
            matchDto1.setWinning_team(m.getWinning_team());

            matchDto1.setTeamsPlaying(convertTeamListToDto(m.getTeamsPlaying()));
            matchDto1.setVenue(convertVenueToDto(m.getVenue()));

            matchDtoList.add(matchDto1);
        }
        return matchDtoList;
    }

    public List<TeamDto>convertTeamListToDto(List<Team> teams){
        List<TeamDto>teamDtoList=new ArrayList<>();

        for(Team team:teams){
            TeamDto teamDto=new TeamDto();
            teamDto.setTid(team.getTid());
            teamDto.setName(team.getName());
            teamDto.setTeam_player(convertPlayerWithoutTeamListToDto(team.getTeam_player()));

            teamDtoList.add(teamDto);
        }

        return teamDtoList;
    }

    public TeamDtoWithoutPlayer convertTeamDtoWithoutPlayerToDto(Team team){
        return new TeamDtoWithoutPlayer(team.getTid(),
                team.getName(),
                team.getScore());
    }
    public TeamDto convertTeamToDto(Team team){
        return new TeamDto(team.getTid(),
                team.getName(),
                team.getScore(),
                convertPlayerWithoutTeamListToDto(team.getTeam_player()));
    }
    public VenueDto convertVenueToDto(Venue venue){
        VenueDto venueDto=new VenueDto();
        venueDto.setVid(venue.getVid());
        venueDto.setName(venue.getName());
        venueDto.setStadium(venue.getStadium());

        return venueDto;
    }
    public List<PlayerDto>convertPlayerListToDto(List<Player>players){
        List<PlayerDto>playerDtoList=new ArrayList<>();
        for(Player player:players){
            PlayerDto playerDto=new PlayerDto();
            playerDto.setName(player.getName());
            playerDto.setPid(player.getPid());
            playerDto.setRole(player.getRole());
            playerDto.setTeam_name(convertTeamDtoWithoutPlayerToDto(player.getTeam_name()));

            playerDtoList.add(playerDto);
        }
        return  playerDtoList;
    }

    public List<PlayerWithoutTeamDto>convertPlayerWithoutTeamListToDto(List<Player>players){
        List<PlayerWithoutTeamDto>playerDtoList=new ArrayList<>();
        for(Player player:players){
            PlayerWithoutTeamDto playerDto=new PlayerWithoutTeamDto();
            playerDto.setName(player.getName());
            playerDto.setPid(player.getPid());
            playerDto.setRole(player.getRole());

            playerDtoList.add(playerDto);
        }
        return  playerDtoList;
    }

    public PlayerDto convertPlayerDto(Player player){
        PlayerDto playerDto=new PlayerDto();
        playerDto.setPid(player.getPid());
        playerDto.setRuns(player.getRuns());
        playerDto.setTeam_name(convertTeamDtoWithoutPlayerToDto(player.getTeam_name()));
        playerDto.setRole(player.getRole());
        playerDto.setName(player.getName());
        playerDto.setWickets(player.getWickets());

        return playerDto;
    }

}
