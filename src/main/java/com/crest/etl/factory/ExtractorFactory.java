package com.crest.etl.factory;

import com.crest.etl.core.Extractor;
import com.crest.etl.core.impl.FileExtractor;

public class ExtractorFactory {

	public static Extractor getExtractor(String name){
		if(name.endsWith("FILE"))
			return new FileExtractor();
		return null;		
		
	}
}
