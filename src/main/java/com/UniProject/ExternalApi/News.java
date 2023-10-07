package com.UniProject.ExternalApi;

import com.UniProject.Pojo.Story;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

@Component
@NoArgsConstructor
@AllArgsConstructor
public class News {
    private List<Story>storyList;


    public List<Story>getStoryList(){
        storyList=new ArrayList<>();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://cricbuzz-cricket.p.rapidapi.com/news/v1/topics/349"))
                .header("X-RapidAPI-Key", "06bde5eae4msh948cfdb85cb93cdp1f257cjsnf926d0985508")
                .header("X-RapidAPI-Host", "cricbuzz-cricket.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();

        HttpResponse<String> response = null;
        try {
            response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        String responseBody = response.body();

        // Parse the JSON response
        JSONObject jsonResponse = new JSONObject(responseBody);
        JSONArray newsList = jsonResponse.getJSONArray("storyList");

        // Iterate through the storyList and extract required attributes
        for (int i = 0; i < newsList.length(); i++) {
            JSONObject storyObject = (JSONObject) newsList.get(i);
            String hline=null;
            String intro=null;
            try{
                JSONObject object = storyObject.getJSONObject("story");
                hline=object.getString("hline");
                intro=object.getString("intro");
                Story story = new Story(hline,intro);
                System.out.println(story);
                storyList.add(story);
            }catch (Exception ignored){

            }

        }

        return storyList;
    }
}
