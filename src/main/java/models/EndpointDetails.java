package models;


import java.util.Map;

public class EndpointDetails {
	private int latency;
	private Map<Integer, Integer> cacheServerMap;
	
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
