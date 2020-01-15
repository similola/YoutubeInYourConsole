package com.youtubeinconsole.client;

import com.microsoft.azure.cognitiveservices.search.videosearch.implementation.BingVideoSearchAPIImpl;
import com.microsoft.azure.cognitiveservices.search.videosearch.models.VideoObject;
import com.microsoft.azure.cognitiveservices.search.videosearch.models.VideosModel;
import com.youtubeinconsole.clientutils.YouTubeSearchUtil;

public class YoutubeSearch {

    public static void SearchYoutube(String subscriptionKey, String searchTerm) {
        BingVideoSearchAPIImpl client = YouTubeSearchUtil.getClient(subscriptionKey);
        VideosModel videoResults = client.bingVideos().search(searchTerm, null);

        if (videoResults == null) {
            System.out.println("Didn't see any video result data..");
        } else {
            if (videoResults.value().size() > 0) {

                int videoIndex = 0;
                for (VideoObject video : videoResults.value()) {
                    if (video.contentUrl().contains("youtube")) {
                        videoIndex++;
                        System.out.println(String.format("---Video Search Result %d---", videoIndex));
                        System.out.println(String.format("Video name: %s", video.name()));
                        System.out.println(String.format("Number of views: %d", video.viewCount()));
                        System.out.println(String.format("Video Link: %s", video.contentUrl()));

                    }

                }

            } else {
                System.out.println("Couldn't find video results!");
            }
        }
    }

    public static void main(String[] args) {
        String key = "";
        String searchTerm = "";
        if (args.length > 0 && args.length == 2) {
            //need to do better error handling later
            System.out.println("Extracting subscription key and search term");
            key = args[0];
            searchTerm = args[1];
        } else {
            System.out.println("No command line arguments found. Please run with subscription key and search term as parameter");
            System.out.println("Run like this on Command Line: java YoutubeSearch <subscriptionkey> <searchterm> ");
        }

        YoutubeSearch.SearchYoutube(key, searchTerm);
    }
}
