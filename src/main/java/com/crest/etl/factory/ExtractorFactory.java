package com.crest.etl.factory;

import com.crest.etl.core.Facade;
import com.crest.etl.core.impl.FileFacade;

public class ExtractorFactory {

	public static Facade getExtractor(String name){
		if(name.endsWith("FILE"))
			return new FileFacade();
		return null;		
		
	}
}
