package com.youtubeinconsole.client;

import com.google.gson.Gson;
import com.microsoft.azure.cognitiveservices.search.videosearch.BingVideos;
import com.microsoft.azure.cognitiveservices.search.videosearch.implementation.BingVideoSearchAPIImpl;
import com.microsoft.azure.cognitiveservices.search.videosearch.models.VideoObject;
import com.microsoft.azure.cognitiveservices.search.videosearch.models.VideosModel;
import com.youtubeinconsole.clientutils.YouTubeSearchUtil;

public class YoutubeSearch {

    public static void SearchYoutube(String subscriptionKey, String searchTerm){
        BingVideoSearchAPIImpl client = YouTubeSearchUtil.getClient(subscriptionKey);
        VideosModel videoResults = client.bingVideos().search(searchTerm,null);

        if (videoResults == null){
            System.out.println("Didn't see any video result data..");
        }
        else{
            if (videoResults.value().size() > 0){

                Gson gson=new Gson();
                System.out.println(String.format("JSON: %s: ",gson.toJson(videoResults)));

            }
            else{
                System.out.println("Couldn't find video results!");
            }
        }
    }

    public static void main(String[] args) {
        //main method to run class goes here, takes in search term as argument
        //call bing search api

        YoutubeSearch.SearchYoutube("subscriptionkeygoeshere","Beyonce");
    }
}
