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
    private TeamDtoWithoutPlayer team1;
    private TeamDtoWithoutPlayer team2;
    private VenueDto venue;
}
