package com.UniProject.DTO;

import com.UniProject.Enteties.MatchInfo;
import lombok.*;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class Match {
    private long mid;
    private String winning_team;
    private Date match_date_time;
}
