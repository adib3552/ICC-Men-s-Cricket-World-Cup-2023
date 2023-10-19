package com.UniProject.Enteties;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long tid;
    private String name;
    @OneToMany(mappedBy = "team_name",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Player> team_player;
    @OneToMany(mappedBy = "team1",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<MatchInfo> team1Match;
    @OneToMany(mappedBy = "team2",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<MatchInfo> team2Match;
    private int score;

}
