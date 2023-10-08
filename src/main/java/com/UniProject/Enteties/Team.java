package com.UniProject.Enteties;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long tid;
    private String name;
    @OneToMany(mappedBy = "team_name")
    private List<Player> team_player;
    @ManyToOne
    @Transient
    private MatchInfo matchId;
    private int score;

    public long getTid() {
        return tid;
    }

    public void setTid(long tid) {
        this.tid = tid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Player> getTeam_player() {
        return team_player;
    }

    public void setTeam_player(List<Player> team_player) {
        this.team_player = team_player;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public MatchInfo getMatchId() {
        return matchId;
    }

    public void setMatchId(MatchInfo matchId) {
        this.matchId = matchId;
    }
}
