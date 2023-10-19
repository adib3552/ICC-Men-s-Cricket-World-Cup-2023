package com.UniProject.DTO;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter

public class PlayerWithoutTeamDto {
    private long pid;
    private String name;
    private int runs;
    private int points;
    private int wickets;
    private String role;
    private String tname;
}
