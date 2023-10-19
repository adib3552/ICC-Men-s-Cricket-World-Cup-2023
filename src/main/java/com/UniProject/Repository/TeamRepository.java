package com.UniProject.Repository;

import com.UniProject.Enteties.Team;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface TeamRepository extends CrudRepository<Team,Long> {

    @Query("select t.name FROM Team t")
    List<String>getAllTeamName();

    Team findByName(String name);
    @Query("select t from Team t order by t.score DESC")
    List<Team>getTeamByScore();

    @Modifying
    @Query("update Team t set t.name=:name where t.tid=:tid")
    void updateTeamName(@Param("name") String name, @Param("tid") long tid);
    @Modifying
    @Query("update Team t set t.score=:score where t.tid=:tid")
    void updateTeamScore(@Param("score") int score,@Param("tid") long tid);

    void deleteByTid(long tid);

}
