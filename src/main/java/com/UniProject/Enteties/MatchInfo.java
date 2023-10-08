package com.UniProject.Enteties;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MatchInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long m_id;
    private Date match_date_time;
    private String winning_team;
    @OneToMany
    @JoinTable(name = "match_played",
                joinColumns = @JoinColumn(name = "mid"),
                inverseJoinColumns = @JoinColumn(name = "tid"))
    private List<Team>teamsPlaying;
    @OneToOne
    private Venue venue;
    @Transient
    private String team1;
    @Transient
    private String team2;

    @Transient
    private String vname;
    public long getM_id() {
        return m_id;
    }

    public void setM_id(long m_id) {
        this.m_id = m_id;
    }

    public Date getMatch_date_time() {
        return match_date_time;
    }

    public void setMatch_date_time(Date match_date_time) {
        this.match_date_time = match_date_time;
    }

    public String getWinning_team() {
        return winning_team;
    }

    public void setWinning_team(String winning_team) {
        this.winning_team = winning_team;
    }

    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }

    public List<Team> getTeamsPlaying() {
        return teamsPlaying;
    }

    public void setTeamsPlaying(List<Team> teamsPlaying) {
        this.teamsPlaying = teamsPlaying;
    }

    public String getTeam1() {
        return team1;
    }

    public void setTeam1(String team1) {
        this.team1 = team1;
    }

    public String getTeam2() {
        return team2;
    }

    public void setTeam2(String team2) {
        this.team2 = team2;
    }

    public String getVname() {
        return vname;
    }

    public void setVname(String vname) {
        this.vname = vname;
    }

}
