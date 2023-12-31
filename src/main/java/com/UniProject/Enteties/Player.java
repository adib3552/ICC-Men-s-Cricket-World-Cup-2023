package com.UniProject.Enteties;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
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
    @ManyToMany(mappedBy = "uDream11")
    private List<User>pDream11=new ArrayList<>();
    private int wickets;
    private String role;
    private String tname;

}
