package models;


import java.util.List;
import java.util.Map;

public class EndpointDetails {
    private int id;
	private int latencyToDatacenter;
    private int numConnectedCacheServers;
    private List<VideoRequest> videoRequests;

    // Map of cacheServerId and Latency
    private Map<CacheServer, Integer> cacheServerMap;

	public EndpointDetails(int id, int latencyToDatacenter, int connectedCacheServerCount) {
	    this.id = id;
	    this.latencyToDatacenter = latencyToDatacenter;
	    this.numConnectedCacheServers = connectedCacheServerCount;
    }

    public List<VideoRequest> getVideoRequests() {
        return videoRequests;
    }
    public void setVideoRequests(List<VideoRequest> videoRequests) {
        this.videoRequests = videoRequests;
    }
	
	public int getLatencyToDatacenter() {
		return latencyToDatacenter;
	}
	public void setLatencyToDatacenter(int latencyToDatacenter) {
		this.latencyToDatacenter = latencyToDatacenter;
	}
	public Map<CacheServer, Integer> getCacheServerMap() {
		return cacheServerMap;
	}
	public void setCacheServerMap(Map<CacheServer, Integer> cacheServerMap) {
		this.cacheServerMap = cacheServerMap;
	}
    public int getNumConnectedCacheServers() {
        return numConnectedCacheServers;
    }

    public void setNumConnectedCacheServers(final int numConnectedCacheServers) {
        this.numConnectedCacheServers = numConnectedCacheServers;
    }

    public String toString() {
        return String.format("Endpoint[id: %1$s, latency to DC: %2$s, cache servers: \n\t%3$s]", id, latencyToDatacenter, cacheServerMap);
    }
}
