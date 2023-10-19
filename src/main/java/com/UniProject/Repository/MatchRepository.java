package com.UniProject.Repository;

import com.UniProject.DTO.MatchDto;
import com.UniProject.Enteties.MatchInfo;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public interface MatchRepository extends CrudRepository<MatchInfo,Long> {
    @Modifying
    @Query("update MatchInfo match set match.winning_team=:team where match.m_id=:mid")
    void updateWinningTeam(@Param("team") String team, @Param("mid") long mid);
    @Modifying
    @Query("update MatchInfo match set match.match_date_time=:time where match.m_id=:mid")
    void updateMatchTime(@Param("time") Date time, @Param("mid") long mid);

    @Modifying
    @Query("delete from MatchInfo m where m.m_id=:mid")
    void deleteByM_id(@Param("mid") long mid);
}
