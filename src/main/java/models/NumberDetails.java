package models;

import java.util.List;

public class NumberDetails {
	private int numVideos;
	private int numEndpoints;
	private int numRequests;
	private int numCacheServers;
	private int cacheSize;
	
	public NumberDetails(List<String> values) {
		this.numVideos = Integer.parseInt(values.get(0));
		this.numEndpoints = Integer.parseInt(values.get(1));
		this.numRequests =Integer.parseInt(values.get(2));
		this.numCacheServers = Integer.parseInt(values.get(3));
		this.cacheSize = Integer.parseInt(values.get(4));
	}
	
	public int getNumVideos() {
		return numVideos;
	}
	public void setNumVideos(int numVideos) {
		this.numVideos = numVideos;
	}
	public int getNumEndpoints() {
		return numEndpoints;
	}
	public void setNumEndpoints(int numEndpoints) {
		this.numEndpoints = numEndpoints;
	}
	public int getNumRequests() {
		return numRequests;
	}
	public void setNumRequests(int numRequests) {
		this.numRequests = numRequests;
	}
	public int getNumCacheServers() {
		return numCacheServers;
	}
	public void setNumCacheServers(int numCacheServers) {
		this.numCacheServers = numCacheServers;
	}
	public int getCacheSize() {
		return cacheSize;
	}
	public void setCacheSize(int cacheSize) {
		this.cacheSize = cacheSize;
	}
	
	@Override
	public String toString() {
		return String.format("NumberDetails [numVideos: %d, numEndpoints: %d, numRequests: %d, numCacheServers: %d, cacheSize: %d]", 
				getNumVideos(), getNumEndpoints(), getNumRequests(), getNumCacheServers(), getCacheSize());
	}
}