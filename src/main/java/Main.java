import models.parser.AlternativeInputParser;

public class Main {
    public static void main(String[] args) throws Exception {
        String fileName = "me_at_the_zoo.in";
//        InputParser parser = new InputParser(fileName);
//        parser.parse();
        
        AlternativeInputParser altParser = new AlternativeInputParser(fileName);
        altParser.parse();
        
//        for (EndpointDetails endpoint : parser.getEndpoints()) {
//        	Timesave.calcTimesave(endpoint);
//        }
//        
//        for (EndpointDetails endpoint : parser.getEndpoints()) {
//        	for (CacheServer server : endpoint.getCacheServerMap().keySet()) {
//        		
//        	}
//        }
    }
}
