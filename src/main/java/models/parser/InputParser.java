package models.parser;

import models.Video;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputParser {
    private File file;
    private Scanner scanner;

    private int videoCount;
    private int endpointCount;
    private int requestDescriptionCount;
    private int cacheServerCount;
    private int cacheServerCapacity;

    private List<Video> videos;

    public InputParser(String fileName) {
        ClassLoader classLoader = this.getClass().getClassLoader();
        this.file = new File(classLoader.getResource(fileName).getFile());
        this.scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
    }

    public void parse() {
        //File is found
        System.out.println("File Found : " + file.exists());
        parseScenarioDetails(parseLineDetails(scanner.nextLine()));
        videos = parseVideos(parseLineDetails(scanner.nextLine()));

        while(scanner.hasNextLine()) {
            System.out.println(scanner.nextLine());
        }
    }

    private List<Video> parseVideos(final List<Integer> integers) {
        // line 2: size of each video in MB
        List<Video> videos = new ArrayList<Video>();
        for(int i=0; i < integers.size() - 1; i++) {
            videos.add(new Video(i, integers.get(i)));
        }
        return videos;
    }

    private void parseScenarioDetails(final List<Integer> integers) {
        // line 1: number of videos, number of endpoints, number of request descriptions, number of cache servers, cache server capacity (MB)
        this.videoCount = integers.get(0);
        this.endpointCount = integers.get(1);
        this.requestDescriptionCount = integers.get(2);
        this.cacheServerCount = integers.get(3);
        this.cacheServerCapacity = integers.get(4);
    }

    private List<Integer> parseLineDetails(String line) {
        String[] splitString = line.split(" ");
        List<Integer> numberList = new ArrayList<Integer>();
        for(String numberString : splitString) {
            numberList.add(new Integer(numberString));
        }
        return numberList;
    }

    // endpoint descriptions
    //  - line 1: latency from dc to endpoint
    //  - line 2: (K) number of cache servers connected to endpoint
    // next K lines: cache id & latency from cache to endpoint
    // request descriptions:
    //  - video id, endpoint id, number of requests from endpoint for video
    
    // test
}
