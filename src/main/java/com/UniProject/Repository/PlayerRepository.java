package com.UniProject.Repository;

import com.UniProject.Enteties.Player;
import com.UniProject.Enteties.Team;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface PlayerRepository extends CrudRepository<Player,Long> {
    Player findByName(String name);

    @Modifying
    @Query("update Player p set p.name=:name where p.id=:pid")
    void updatePlayerName(@Param("name") String name, @Param("pid") long pid);
    @Modifying
    @Query("update Player p set p.runs=:run, p.wickets=:wicket where p.id=:pid")
    void updatePlayerRunAndWicket(@Param("run") int run, @Param("wicket")int wicket, @Param("pid")long pid);
    @Modifying
    @Query("update Player p set p.tname=:tname, p.team_name=:team where p.id=:pid")
    void updatePlayerTeam(@Param("tname") String tname, @Param("team") Team team, @Param("pid") long pid);

    void deleteByPid(long pid);
}
