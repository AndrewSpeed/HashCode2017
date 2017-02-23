package models;


import java.util.List;
import java.util.Map;

public class EndpointDetails {
	private int latency;
	// Map of cacheServerId and LatencyDifference
	private Map<Integer, Integer> cacheServerMap;
	private List<VideoRequest> videoRequests;
	
	public List<VideoRequest> getVideoRequests() {
		return videoRequests;
	}
	public void setVideoRequests(List<VideoRequest> videoRequests) {
		this.videoRequests = videoRequests;
	}
	public int getLatency() {
		return latency;
	}
	public void setLatency(int latency) {
		this.latency = latency;
	}
	public Map<Integer, Integer> getCacheServerMap() {
		return cacheServerMap;
	}
	public void setCacheServerMap(Map<Integer, Integer> cacheServerMap) {
		this.cacheServerMap = cacheServerMap;
	}
}
