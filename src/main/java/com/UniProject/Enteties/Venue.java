package com.UniProject.Enteties;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Venue {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long vid;
    private String name;
    private String Stadium;
    @OneToOne(mappedBy = "venue")
    @JoinColumn(name = "venue_id")
    private MatchInfo matchId;

    public long getVid() {
        return vid;
    }

    public void setVid(String vid) {
        this.vid = Long.parseLong(vid);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MatchInfo getMatchId() {
        return matchId;
    }

    public void setMatchId(MatchInfo matchId) {
        this.matchId = matchId;
    }

    public void setVid(long vid) {
        this.vid = vid;
    }

    public String getStadium() {
        return Stadium;
    }

    public void setStadium(String stadium) {
        Stadium = stadium;
    }
}
