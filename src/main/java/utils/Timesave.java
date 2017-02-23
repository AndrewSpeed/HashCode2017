package utils;

import java.util.List;
import java.util.Map;

import models.CacheServer;
import models.EndpointDetails;
import models.VideoRequest;

public class Timesave {
	
	public static void calcTimesave(EndpointDetails ed){
		Map<CacheServer, Integer> caches = ed.getCacheServerMap();
		List<VideoRequest> videoRequests = ed.getVideoRequests();
		
		for(CacheServer server : caches.keySet()){
			int timeDiff = caches.get(server);
			
			for (VideoRequest videoRequest : videoRequests ) {
				int requestNo = videoRequest.getNumRequests();
				
				int totalTimeSave = timeDiff * requestNo;
				
				if (server.getTotalTimeSavePerVideo().containsKey(videoRequest.getVideoId())) {
					int currentTimeSave = server.getTotalTimeSavePerVideo().get(videoRequest.getVideoId());
					server.getTotalTimeSavePerVideo().put(videoRequest.getVideoId(), currentTimeSave + totalTimeSave);
				} else {
					server.getTotalTimeSavePerVideo().put(videoRequest.getVideoId(), totalTimeSave);
				}
			}
		}
	}
}
