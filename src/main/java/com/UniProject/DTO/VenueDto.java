package com.UniProject.DTO;

import com.UniProject.Enteties.MatchInfo;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class VenueDto {
    private long vid;
    private String name;
    private String Stadium;
    //private MatchDto matchId;
}
