package models.parser;

import java.io.File;

public class InputParser {
    String fileName;

    public InputParser(String fileName) {
        this.fileName = fileName;

        ClassLoader classLoader = this.getClass().getClassLoader();
        File file = new File(classLoader.getResource(fileName).getFile());

        //File is found
        System.out.println("File Found : " + file.exists());
    }
    // line 1: number of videos, number of endpoints, number of request descriptions, number of cache servers, cache server capacity (MB)
    // line 2: size of each video in MB
    // endpoint descriptions
    //  - line 1: latency from dc to endpoint
    //  - line 2: (K) number of cache servers connected to endpoint
    // next K lines: cache id & latency from cache to endpoint
    // request descriptions:
    //  - video id, endpoint id, number of requests from endpoint for video
}
