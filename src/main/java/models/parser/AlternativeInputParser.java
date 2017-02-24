package models.parser;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import models.NumberDetails;

public class AlternativeInputParser {
	private File file;
    private Scanner scanner;

	public AlternativeInputParser(String fileName) {
        ClassLoader classLoader = this.getClass().getClassLoader();
        this.file = new File(classLoader.getResource(fileName).getFile());
        this.scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
    }
	
	public void parse() throws Exception {
        //File is found
        System.out.println("File Found : " + file.exists());
        NumberDetails numDetails = parseObjectFromString(scanner.nextLine(), NumberDetails.class);
        
        System.out.println(numDetails.toString());
    }
	
	private <T> T parseObjectFromString(String s, Class<T> clazz) throws Exception {
		return clazz.getConstructor(new Class[] {List.class}).newInstance(Arrays.asList(s.split(" ")));
	}
}
