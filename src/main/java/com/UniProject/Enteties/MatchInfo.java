package com.UniProject.Enteties;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class MatchInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long m_id;
    private Date match_date_time;
    private String winning_team;
    @ManyToOne
    private Venue venue;
    @ManyToOne
    private Team team1;
    @ManyToOne
    private Team team2;

    @Transient
    private String vname;

}
