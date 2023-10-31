package com.UniProject.Enteties;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String first_name;
    private String last_name;
    private String email;
    private String password;
    private long phone_no;
    private String role;
    private boolean isEnabled;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "dream11",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "player_id"))
    private List<Player>uDream11=new ArrayList<>();
    private int dreamPoints;
}
