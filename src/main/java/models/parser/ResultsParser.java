package models.parser;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

import models.CacheServer;
import models.Results;

public class ResultsParser {
	public static void writeResultsToFile(Results results) throws IOException{
		
		File fout = new File("output.txt");
		FileOutputStream fos = new FileOutputStream(fout);
	 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
		List<CacheServer> cacheServers = results.getCacheServers(); 
		bw.write(cacheServers.size());
		bw.newLine();
		for(CacheServer server : cacheServers) {
			bw.write(server.getId() + " ");
			for(int videoId : server.getVideos().keySet()) {
				bw.write(videoId + " ");
			}
			bw.newLine();
		}
		bw.newLine();
	 
		bw.close();
		
	}
}
