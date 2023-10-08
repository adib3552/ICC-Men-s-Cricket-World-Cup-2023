package com.UniProject.DTO;

import com.UniProject.Enteties.MatchInfo;
import com.UniProject.Enteties.Venue;
import lombok.*;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class MatchDto {
    private long m_id;
    private Date match_date_time;
    private String winning_team;
    private List<TeamDto>teamsPlaying;
    private VenueDto venue;
    private String team1;
    private String team2;
    private String vname;

    public MatchInfo getMatchInfo(){
        MatchInfo matchInfo=new MatchInfo();
        matchInfo.setMatch_date_time(this.match_date_time);
        matchInfo.setTeam1(this.team1);
        matchInfo.setTeam2(this.team2);
        matchInfo.setVname(vname);

        return matchInfo;
    }
}
