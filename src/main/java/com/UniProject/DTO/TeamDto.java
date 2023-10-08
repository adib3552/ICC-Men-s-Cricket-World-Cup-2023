package com.UniProject.DTO;

import com.UniProject.Enteties.MatchInfo;
import com.UniProject.Enteties.Player;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class TeamDto {

    private long tid;
    private String name;
    private List<PlayerDto> team_player;
    private MatchDto matchId;
}
