package models.parser;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import models.EndpointDetails;
import models.NumberDetails;
import models.Video;

public class AlternativeInputParser {
	private File file;
    private Scanner scanner;
    private int endpointCount;

	public AlternativeInputParser(String fileName) {
        ClassLoader classLoader = this.getClass().getClassLoader();
        this.file = new File(classLoader.getResource(fileName).getFile());
        this.scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
    }
	
	public void parse() throws Exception {
        //File is found
		System.out.println("File Found : " + file.exists());
        NumberDetails numDetails = parseObjectFromString(scanner.nextLine(), NumberDetails.class);
        endpointCount = numDetails.getNumEndpoints();
        Video video = parseObjectFromString(scanner.nextLine(), Video.class);
        List<EndpointDetails> endpointDetails = parseEndpoints(scanner);
        System.out.println(numDetails.toString());
        System.out.println(video.toString());
        System.out.println(endpointDetails.toString());
    }
	
	private List<EndpointDetails> parseEndpoints(Scanner scanner) throws Exception {
        // endpoint descriptions
        //  - line 1: latency from dc to endpoint
        //  - line 2: (K) number of cache servers connected to endpoint
        List<EndpointDetails> endpoints = new ArrayList<EndpointDetails>();
        for(int i=0; i < endpointCount; i++) {
        	EndpointDetails endpoint = parseObjectFromString(i + " " + scanner.nextLine(), EndpointDetails.class);
            endpoints.add(endpoint);
        }
        return endpoints;
    }
	
	private <T> T parseObjectFromString(String s, Class<T> clazz) throws Exception {
		return clazz.getConstructor(new Class[] {List.class}).newInstance(Arrays.asList(s.split(" ")));
	}
}
