package com.crest.etl.core.impl;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.crest.etl.core.Loader;

public class FileLoader implements Loader {

	@Override
	public void load(List<String> transformedValues, String... options) throws IOException {

		String outputDirectory = options[0];
		String fileName = options[1];
		File file = new File(outputDirectory + System.getProperty("file.separator") + fileName);
		if (file.createNewFile()) {
			System.out.println("File is created!");
		} else {
			System.out.println("File already exists.");
		}		
		FileWriter writer = new FileWriter(file); 		
		for(String str: transformedValues) {
		  writer.write(str);
		}
		writer.close();

	}

}
