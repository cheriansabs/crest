package com.crest.etl.factory;


import com.crest.etl.core.Loader;
import com.crest.etl.core.impl.FileLoader;

public class LoaderFactory {

	public static Loader getLoader(String name){
		if(name.endsWith("FILE"))
			return new FileLoader();
		return null;
		
		
	}
	
}
