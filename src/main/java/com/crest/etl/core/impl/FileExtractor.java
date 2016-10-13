package com.crest.etl.core.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.crest.etl.core.Extractor;
import com.crest.etl.core.Loader;
import com.crest.etl.core.Transformer;
import com.crest.etl.util.FileUtils;

public class FileExtractor implements Extractor {

	List<Transformer> lstTransformers;
	List<String> lstTransformedStrings;
	Loader loader;
	
	
	@Override
	public void extract(String... options) throws IOException {
		
		
		String filePath=options[0];
		String outputDirectory=options[1];
		if((filePath!=null)&&outputDirectory!=null){
			
			File[] files = FileUtils.getFiles(filePath);
			for(File file : files){
				Scanner s = new Scanner(file);
				ArrayList<String> list = new ArrayList<String>();
				while (s.hasNext()){
				    list.add(s.next());
				}
				s.close();
				lstTransformedStrings=list;
				lstTransformers.forEach(transformer->{
					lstTransformedStrings = transformer.transform(lstTransformedStrings);
					
				});
				loader.load(lstTransformedStrings, outputDirectory,file.getName());
				
			}
		}
		else{
			
		}
		
	
		
	}


	@Override
	public void setTransformers(List<Transformer> lstTransformers) {
		this.lstTransformers=lstTransformers;
		
	}


	@Override
	public void setLoader(Loader loader) {
		this.loader=loader;
		
	}

}
