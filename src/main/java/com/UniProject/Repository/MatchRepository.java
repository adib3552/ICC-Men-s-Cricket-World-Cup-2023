package com.UniProject.Repository;

import com.UniProject.DTO.MatchDto;
import com.UniProject.Enteties.MatchInfo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface MatchRepository extends CrudRepository<MatchInfo,Long> {

}
