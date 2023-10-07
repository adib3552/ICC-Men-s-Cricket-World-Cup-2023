package com.UniProject.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long pid;
    private String name;
    private int runs;
    private int points;
    @ManyToOne
    @JoinColumn(name = "Team_id")
    private Team team_name;

    @ManyToMany(mappedBy = "dream11")
    private List<User>dream11;

    public long getPid() {
        return pid;
    }

    public void setPid(long pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRuns() {
        return runs;
    }

    public void setRuns(int runs) {
        this.runs = runs;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public Team getTeam_name() {
        return team_name;
    }

    public void setTeam_name(Team team_name) {
        this.team_name = team_name;
    }

}
