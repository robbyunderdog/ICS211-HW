package edu.ics211.h01;

import java.io.*;
import java.util.*;

public class ReadingFiles {
	
	public static int FileChar(String name) {
		
		int charCount = 0;
		String line;
		 
		try {    //tries to read the .txt file and read all of its contents and counts the characters
			File inFile = new File(name);
			Scanner scan = new Scanner(inFile);
			
			while (scan.hasNextLine()) {    //actually counts the characters in the file
				line = scan.nextLine();
				charCount += line.length();
			}
			scan.close();
			return charCount;    //returns character count
			
		} catch (FileNotFoundException ex) {    //if file not found, returns -1 and writes that file name was incorrect
			System.out.println("\nFile " + name + " not found, please make sure file name is correct and the file is in the correct location.");
			return -1;
			
		}
	}
}
