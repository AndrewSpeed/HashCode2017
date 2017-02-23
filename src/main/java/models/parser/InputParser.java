package models.parser;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import models.CacheServer;
import models.EndpointDetails;
import models.Video;
import models.VideoRequest;

public class InputParser {
    private File file;
    private Scanner scanner;

    private int videoCount;
    private int endpointCount;
    private int requestCount;
    private int cacheServerCount;
    private int cacheServerCapacity;

    private List<Video> videos;
    public List<Video> getVideos() {
		return videos;
	}

	public void setVideos(List<Video> videos) {
		this.videos = videos;
	}

	private List<EndpointDetails> endpoints;
    private List<VideoRequest> requests;

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
        endpoints = parseEndpoints(scanner);
        requests = parseRequests(scanner);
        
        for (VideoRequest request : requests) {
        	EndpointDetails temp = endpoints.get(request.getEndpointId());
        	
        	temp.videoRequests.add(request);
        }
    }

    private List<VideoRequest> parseRequests(final Scanner scanner) {
        // request descriptions:
        //  - video id, endpoint id, number of requests from endpoint for video
        List<VideoRequest> requests = new ArrayList<VideoRequest>();
        for(int i=0; i < requestCount; i++) {
            List<Integer> videoIntegers = parseLineDetails(scanner.nextLine());
            VideoRequest request = new VideoRequest(videoIntegers.get(0), videoIntegers.get(1), videoIntegers.get(2));
            requests.add(request);
        }
        System.out.println(requests);
        return requests;
    }


    private List<EndpointDetails> parseEndpoints(Scanner scanner) {
        // endpoint descriptions
        //  - line 1: latency from dc to endpoint
        //  - line 2: (K) number of cache servers connected to endpoint
        List<EndpointDetails> endpoints = new ArrayList<EndpointDetails>();
        for(int i=0; i < endpointCount; i++) {
            List<Integer> endpointIntegers = parseLineDetails(scanner.nextLine());
            int latency = endpointIntegers.get(0);
            int connectedCacheServerCount = endpointIntegers.get(1);

            EndpointDetails endpoint = new EndpointDetails(i, latency, connectedCacheServerCount);
            parseCachesForEndpoint(scanner, endpoint);

            endpoints.add(endpoint);
        }
        System.out.println(endpoints);
        return endpoints;
    }

    private void parseCachesForEndpoint(Scanner scanner, EndpointDetails endpoint) {
        // endpoint descriptions
        //  - line 1: latency from dc to endpoint
        //  - line 2: (K) number of cache servers connected to endpoint
        // next K lines: cache id & latency from cache to endpoint
        Map<CacheServer, Integer> caches = new HashMap<CacheServer, Integer>();
        for(int i=0; i < endpoint.getNumConnectedCacheServers(); i++) {
            List<Integer> cacheIntegers = parseLineDetails(scanner.nextLine());
            CacheServer cache = new CacheServer(cacheIntegers.get(0), cacheIntegers.get(1));
            caches.put(cache, cacheIntegers.get(1));
        }
        endpoint.setCacheServerMap(caches);
    }

    private List<Video> parseVideos(final List<Integer> integers) {
        // line 2: size of each video in MB
        List<Video> videos = new ArrayList<Video>();
        for(int i=0; i < integers.size(); i++) {
            videos.add(new Video(i, integers.get(i)));
        }
        System.out.println(videos);
        return videos;
    }

    private void parseScenarioDetails(final List<Integer> integers) {
        // line 1: number of videos, number of endpoints, number of request descriptions, number of cache servers, cache server capacity (MB)
        this.videoCount = integers.get(0);
        this.endpointCount = integers.get(1);
        this.requestCount = integers.get(2);
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

	public List<EndpointDetails> getEndpoints() {
		return endpoints;
	}

	public void setEndpoints(List<EndpointDetails> endpoints) {
		this.endpoints = endpoints;
	}

	public List<VideoRequest> getRequests() {
		return requests;
	}

	public void setRequests(List<VideoRequest> requests) {
		this.requests = requests;
	}

    // endpoint descriptions
    //  - line 1: latency from dc to endpoint
    //  - line 2: (K) number of cache servers connected to endpoint
    // next K lines: cache id & latency from cache to endpoint
    // request descriptions:
    //  - video id, endpoint id, number of requests from endpoint for video
    
    // test
}
