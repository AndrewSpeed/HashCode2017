package models;

public class VideoRequest {
	private int videoId;
	private int endpointId;
	private int numRequests;

	public VideoRequest(int videoId, int endpointId, int requestCount) {
		this.videoId = videoId;
		this.endpointId = endpointId;
		this.numRequests = requestCount;
	}


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

	public String toString() {
	    return String.format("Request:[videoId: %1$s, endpointId: %2$s, number of requests: %3$s]", videoId, endpointId, numRequests);
    }

}
