package com.UniProject.Controller;

import com.UniProject.DTO.MatchDto;
import com.UniProject.Enteties.MatchInfo;
import com.UniProject.Enteties.Team;
import com.UniProject.ExternalApi.News;
import com.UniProject.DTO.Story;
import com.UniProject.Services.MatchService;
import com.UniProject.Services.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/public")
public class PublicController {

    @Autowired
    private News news;

    @Autowired
    private MatchService matchService;

    @Autowired
    private TeamService teamService;

    @GetMapping("/news")
    public List<Story>showNews(){
        return news.getStoryList();
    }

    @GetMapping("/matches")
    public List<MatchDto>showAllMatches(){
        return matchService.getAllMatch();
    }
    @GetMapping("/team")
    public List<String>showAllTeamName(){
        return teamService.showAllTeamName();
    }
    @GetMapping("/team/{name}")
    public Team showTeamByName(@PathVariable String name){
        return teamService.showTeamInfoByName(name);
    }
}
