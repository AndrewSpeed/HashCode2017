import models.CacheServer;
import models.EndpointDetails;
import models.parser.InputParser;
import utils.Timesave;

public class Main {
    public static void main(String[] args) {
        String fileName = "me_at_the_zoo.in";
        InputParser parser = new InputParser(fileName);
        parser.parse();
        
        for (EndpointDetails endpoint : parser.getEndpoints()) {
        	Timesave.calcTimesave(endpoint);
        }
        
        for (EndpointDetails endpoint : parser.getEndpoints()) {
        	for (CacheServer server : endpoint.getCacheServerMap().keySet()) {
        		
        	}
        }
    }
}
