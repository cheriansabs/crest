package com.crest.etl.util;

import java.io.File;

public class FileUtils {

	public static File[] getFiles(String dir){
		
		return new File(dir).listFiles();
		
	}
	
}
