package com.UniProject.Services;

import com.UniProject.DTO.*;
import com.UniProject.Enteties.*;
import com.UniProject.Repository.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class MatchService {

    @Autowired
    private MatchRepository matchRepository;
    @Autowired
    private VenueRepository venueRepository;

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    UserRepository userRepository;

    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    UserService userService;

    @Autowired
    TeamService teamService;

    @Autowired
    private DtoImpl dto;

    public MatchInfo addMatch(MatchDtoForInsert matchDtoForInsert){
        MatchInfo matchInfo=new MatchInfo();
        matchInfo.setVenue(venueRepository.findByName(matchDtoForInsert.getVenue()));
        List<Team>teams1=new ArrayList<>();
        List<Team>teams2=new ArrayList<>();

        matchInfo.setTeam1(teamRepository.findByName(matchDtoForInsert.getTeam1()));
        matchInfo.setTeam2(teamRepository.findByName(matchDtoForInsert.getTeam2()));

        matchInfo.setWinning_team(matchDtoForInsert.getWinning_team());

        return matchRepository.save(matchInfo);
    }
    public List<MatchDto> getAllMatch(){
        List<MatchInfo>matches = (List<MatchInfo>) matchRepository.findAll();
        return dto.convertMatchListToDto(matches);
    }
    @Transactional
    public boolean updateWinningTeam(Match match){
        try{
            Team team=teamRepository.findByName(match.getWinning_team());
            int tempScore=team.getScore();
            tempScore+=2;
            matchRepository.updateWinningTeam(match.getWinning_team(),match.getMid());
            teamRepository.updateTeamScore(tempScore,team.getTid());
            List<Player>players=playerRepository.getPlayersOfTeam(match.getWinning_team());
            for(Player player:players){
                int tempPoint=player.getPoints()+10;
                playerRepository.updatePlayerPoints(tempPoint,player.getPid());
                entityManager.refresh(player);
            }
            List<User>users= (List<User>) userRepository.findAll();

            for(User user:users){
                System.out.println(user.getFirst_name());
                userService.updateDreamPoints(user.getId());
            }

        }catch (Exception e){
            return false;
        }
        return true;
    }
    @Transactional
    public boolean updateMatchTime(Match match){
        try{
            matchRepository.updateMatchTime(match.getMatch_date_time(),match.getMid());
        }catch (Exception e){
            return false;
        }
        return true;
    }
    @Transactional
    public boolean deleteMatch(MatchDto match){
        try{
            matchRepository.deleteByM_id(match.getM_id());
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

}
