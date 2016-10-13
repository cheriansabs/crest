package com.crest.etl.core.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.crest.etl.core.Extractor;

public class FileExtractor implements Extractor<File> {

	@Override
	public List<String> extract(File file) throws Exception {
		List<String> list = new ArrayList<>();
		Scanner s = new Scanner(file);
		s.useDelimiter("\r\n");
		while (s.hasNext()){
		    list.add(s.next());
		}
		s.close();
		return list;
	}

}
