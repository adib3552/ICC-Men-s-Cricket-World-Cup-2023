package com.UniProject.Services;

import com.UniProject.Entities.MatchInfo;
import com.UniProject.Repository.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MatchService {

    @Autowired
    private MatchRepository matchRepository;

    public List<MatchInfo> getAllMatch(){
        return (List<MatchInfo>) matchRepository.findAll();
    }
}
