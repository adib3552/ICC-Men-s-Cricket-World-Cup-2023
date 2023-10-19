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
            matchDto1.setTeam1(convertTeamDtoWithoutPlayerToDto(m.getTeam1()));
            matchDto1.setTeam2(convertTeamDtoWithoutPlayerToDto(m.getTeam2()));

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
    public Player covertPlayerDtoWithoutTeamDtoToPlayer(PlayerWithoutTeamDto playerDto){
        Player player=new Player();
        player.setName(playerDto.getName());
        player.setPoints(playerDto.getPoints());
        player.setRole(playerDto.getRole());
        player.setRuns(playerDto.getRuns());
        player.setWickets(playerDto.getWickets());
        player.setTname(playerDto.getTname());

        return player;
    }
    public MatchInfo convertMatchDtoForInsert(MatchDtoForInsert matchDto){
        MatchInfo matchInfo=new MatchInfo();
        matchInfo.setMatch_date_time(matchDto.getMatch_date_time());

        return matchInfo;
    }
    public PlayerDto covertPlayerDtoWithoutTeamDtoToPlayerDto(PlayerWithoutTeamDto playerDto){
        PlayerDto player=new PlayerDto();
        player.setName(playerDto.getName());
        player.setPoints(playerDto.getPoints());
        player.setRole(playerDto.getRole());
        player.setRuns(playerDto.getRuns());
        player.setWickets(playerDto.getWickets());


        return player;
    }
    public Team convertTeamDtoWithoutPlayerToTeam(TeamDtoWithoutPlayer teamDto){
        Team team=new Team();
        team.setName(teamDto.getName());
        team.setScore(teamDto.getScore());

        return team;
    }
    public VenueDto convertVenueToDto(Venue venue){
        VenueDto venueDto=new VenueDto();
        venueDto.setVid(venue.getVid());
        venueDto.setName(venue.getName());
        venueDto.setLocation(venue.getLocation());

        return venueDto;
    }

    public Venue covertVenueDtoToVenue(VenueDto venueDto){
        Venue venue = new Venue();
        venue.setName(venueDto.getName());
        venue.setLocation(venueDto.getLocation());

        return venue;
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
            playerDto.setTname(player.getTname());

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
