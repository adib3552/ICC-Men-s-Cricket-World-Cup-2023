package com.UniProject.Enteties;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Venue {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long vid;
    private String name;
    private String location;
    @OneToMany(mappedBy = "venue",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<MatchInfo> matches;

}
