import models.parser.InputParser;

public class Main {
    public static void main(String[] args) {
        String fileName = "me_at_the_zoo.in";
        InputParser parser = new InputParser(fileName);
        parser.parse();
    }
}
