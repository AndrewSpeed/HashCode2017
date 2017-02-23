package models;

public class VideoRequest {
	private int videoId;
	private int endpointId;
	private int numRequests;
	public int getVideoId() {
		return videoId;
	}
	public void setVideoId(int videoId) {
		this.videoId = videoId;
	}
	public int getEndpointId() {
		return endpointId;
	}
	public void setEndpointId(int endpointId) {
		this.endpointId = endpointId;
	}
	public int getNumRequests() {
		return numRequests;
	}
	public void setNumRequests(int numRequests) {
		this.numRequests = numRequests;
	}
	
}
