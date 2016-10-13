package com.crest.etl;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.crest.etl.core.Facade;
import com.crest.etl.core.Transformer;
import com.crest.etl.factory.ExtractorFactory;
import com.crest.etl.factory.LoaderFactory;
import com.crest.etl.factory.TransformerFactory;

public class TestETL1 {

	
	
	
	@Test
	public void testWordCount() {
		
		Facade extractor = ExtractorFactory.getExtractor("FILE");
		List<Transformer> lstTransformers = new ArrayList<>();
		lstTransformers.add(TransformerFactory.getTransformer("WORDCOUNT"));
		extractor.setTransformers(lstTransformers);
		extractor.setLoader(LoaderFactory.getLoader("FILE"));
		
		try {
			
			extractor.extractTransformLoad("F:\\tmp\\folder_1","F:\\tmp\\folder_2");
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
	}

}