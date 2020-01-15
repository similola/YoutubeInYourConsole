# Youtube In Command Line

## Project Motivation

I thought it would be cool to play around with some Microsoft Cognitive Services APIs.
What if you could search youtube for videos without opening your web browser? Cool right- so I decided to build it.

The idea for this project is to be able to search youtube from your Command Line.
This project uses the Bing Video Search API to display a list of youtube videos on your command line based on your search term.

This project uses gradle for dependency management.

## How to Run locally
* Create a Bing Search v7 resource in the Azure Portal and copy the subscription key (you will need this to run the program via command line)
* Clone project to repository
* Navigate to the root of project in Command Line/Terminal
* Clean and Build the gradle project to pull all necessary libraries from the dependencies listed in build.gradle. Run this command:

>gradlew clean build

* Run this command and pass in the Bing Search API subscription key and your search term
>gradlew run --args="subscriptionkeyhere searchtermhere"

## On the TODO List
* Display JSON results in a prettier way. Ideally we want to parse through the JSON and extract the youtube video title, number of views and link. We also want to restrict to only videos on YouTube (Bing searches for videos on all sites)
* Add tests

