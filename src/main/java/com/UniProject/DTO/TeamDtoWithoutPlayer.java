package com.UniProject.DTO;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class TeamDtoWithoutPlayer {
    private long tid;
    private String name;
    private int score;
}
