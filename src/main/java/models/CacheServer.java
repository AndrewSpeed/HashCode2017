package models;

import java.util.Map;

public class CacheServer {
	private int id;
	private int capacity;
	// Map if videoId and Video object
	private Map<Integer, Video> videos;

	public CacheServer(int id, int capacity) {
		this.id = id;
		this.capacity = capacity;
	}
	
	private Map<Integer, Integer> totalTimeSavePerVideo;
	
	public Map<Integer, Integer> getTotalTimeSavePerVideo() {
		return totalTimeSavePerVideo;
	}
	public void setTotalTimeSavePerVideo(
			Map<Integer, Integer> totalTimeSavePerVideo) {
		this.totalTimeSavePerVideo = totalTimeSavePerVideo;
	}
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


    @Override
	public String toString() {
        return String.format("Cache[id: %1$s, capacity: %2$s, videos: %3$s]", id, capacity, videos);
    }
}
