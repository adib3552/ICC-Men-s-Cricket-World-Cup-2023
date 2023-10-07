package com.UniProject.Repository;

import com.UniProject.Entities.MatchInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface MatchRepository extends CrudRepository<MatchInfo,Long> {
}
