package com.UniProject.DTO;

import com.UniProject.Enteties.Team;
import com.UniProject.Enteties.User;
import lombok.*;


import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class PlayerDto {
    private long pid;
    private String name;
    private int runs;
    private int points;
    private TeamDto team_name;
    //private List<User> dream11;
    private int wickets;
    private String role;
    private String tname;
}
