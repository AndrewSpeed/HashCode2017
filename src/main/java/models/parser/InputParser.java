package models.parser;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class InputParser {
    File file;
    Scanner scanner;

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
        while(scanner.hasNextLine()) {
            System.out.println(scanner.nextLine());
        }

    }
    // line 1: number of videos, number of endpoints, number of request descriptions, number of cache servers, cache server capacity (MB)
    // line 2: size of each video in MB
    // endpoint descriptions
    //  - line 1: latency from dc to endpoint
    //  - line 2: (K) number of cache servers connected to endpoint
    // next K lines: cache id & latency from cache to endpoint
    // request descriptions:
    //  - video id, endpoint id, number of requests from endpoint for video
    
    // test
}
