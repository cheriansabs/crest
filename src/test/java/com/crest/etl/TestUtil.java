package com.crest.etl;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class TestUtil {

	public static boolean checkIfFilesAreCapitalized(String outputDirectory) throws FileNotFoundException{
		
		File[] files = new File(outputDirectory).listFiles();
		for(File file : files){
			
			Scanner s = new Scanner(file);
			s.useDelimiter("\r\n");
			ArrayList<String> list = new ArrayList<String>();
			while (s.hasNext()){
				
			   if(!checkForUpperCase(s.next().replaceAll("\\s+","")))
				   return false;
			}
			
		}
		
		return true;
	}

	private static boolean checkForUpperCase(String s) {
		for (int i=0; i<s.length(); i++)
		{
			if (!Character.isUpperCase(s.charAt(i)))
			{
				return false;
			}
		}
		return true;
		
	}
	
	public static boolean checkWordCount(String outputDirectory,String expectedOutput) throws FileNotFoundException{
		
		File[] files = new File(outputDirectory).listFiles();
		for(File file : files){
			
			Scanner s = new Scanner(file);
			s.useDelimiter("\r\n");
			ArrayList<String> list = new ArrayList<String>();
			while (s.hasNext()){
				
			   if(s.next().equalsIgnoreCase(expectedOutput))
				   return true;
			}
			
		}
		
		return false;
	}
	
}
