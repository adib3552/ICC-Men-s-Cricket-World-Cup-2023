package com.UniProject.Repository;

import com.UniProject.Entities.Team;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface TeamRepository extends CrudRepository<Team,Long> {

    @Query("select t.name FROM Team t")
    List<String>getAllTeamName();

    Team findByName(String name);
}
