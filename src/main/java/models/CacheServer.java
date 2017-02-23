package models;

import java.util.Map;

public class CacheServer {
	private int id;
	private int capacity;
	// Map if videoId and Video object
	private Map<Integer, Video> videos;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public Map<Integer, Video> getVideos() {
		return videos;
	}
	public void setVideos(Map<Integer, Video> videos) {
		this.videos = videos;
	}
}
