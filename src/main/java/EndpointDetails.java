

import java.util.Map;

public class EndpointDetails {
	private int latency;
	private Map<String, String> cacheServerMap;
	
	public int getLatency() {
		return latency;
	}
	public void setLatency(int latency) {
		this.latency = latency;
	}
	public Map<String, String> getCacheServerMap() {
		return cacheServerMap;
	}
	public void setCacheServerMap(Map<String, String> cacheServerMap) {
		this.cacheServerMap = cacheServerMap;
	}
}
