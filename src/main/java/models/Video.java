package models;

import java.util.List;

public class Video {
	private int id;
	private int size;

	public Video(int id, int size) {
	    this.id = id;
	    this.size = size;
    }
	
	public Video(List<String> values) {
	    this.id = Integer.parseInt(values.get(0));
	    this.size = Integer.parseInt(values.get(1));
    }
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
    }

    @Override
	public String toString() {
	    return String.format("Video[id: %d, size: %d]", id, size);
    }
}
