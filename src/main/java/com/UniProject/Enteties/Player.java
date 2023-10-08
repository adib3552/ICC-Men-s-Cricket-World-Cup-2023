package com.UniProject.Enteties;

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
    private int wickets;
    private String role;
    @Transient
    private String tname;

    public List<User> getDream11() {
        return dream11;
    }

    public void setDream11(List<User> dream11) {
        this.dream11 = dream11;
    }

    public int getWickets() {
        return wickets;
    }

    public void setWickets(int wickets) {
        this.wickets = wickets;
    }

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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }
}
