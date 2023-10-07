package com.UniProject.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MatchInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long m_id;
    private Date match_date_time;
    private String venue;

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

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }
}
