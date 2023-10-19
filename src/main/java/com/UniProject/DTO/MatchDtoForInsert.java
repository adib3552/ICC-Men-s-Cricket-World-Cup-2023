package com.UniProject.DTO;

import lombok.*;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class MatchDtoForInsert {
    private long m_id;
    private Date match_date_time;
    private String winning_team;
    private String team1;
    private String team2;
    private String venue;
}
