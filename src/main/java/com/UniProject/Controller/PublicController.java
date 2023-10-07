package com.UniProject.Controller;

import com.UniProject.Entities.MatchInfo;
import com.UniProject.Entities.Team;
import com.UniProject.ExternalApi.News;
import com.UniProject.Pojo.Story;
import com.UniProject.Services.MatchService;
import com.UniProject.Services.TeamService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
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
    public List<MatchInfo>showAllMatches(){
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
