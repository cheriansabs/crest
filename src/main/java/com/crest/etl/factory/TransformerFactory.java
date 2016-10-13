package com.crest.etl.factory;

import com.crest.etl.core.Transformer;
import com.crest.etl.core.impl.CapitalizeListTransformer;
import com.crest.etl.core.impl.WordCountTransformer;

public class TransformerFactory {

	
	public static Transformer getTransformer(String name){
		if(name.endsWith("CAPITALIZE"))
			return new CapitalizeListTransformer();
		else 
			if(name.endsWith("WORDCOUNT"))
				return new WordCountTransformer();
		return null;
		
		
	}
}
