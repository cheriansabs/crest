package com.crest.etl;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.crest.etl.core.Facade;
import com.crest.etl.core.Transformer;
import com.crest.etl.factory.ExtractorFactory;
import com.crest.etl.factory.FacadeFactory;
import com.crest.etl.factory.LoaderFactory;
import com.crest.etl.factory.TransformerFactory;

public class TestETL1 {

	
	
	
	@Test
	public void testWordCount() {
		
		Facade facade = FacadeFactory.getExtractor("FILE");
		List<Transformer> lstTransformers = new ArrayList<>();
		lstTransformers.add(TransformerFactory.getTransformer("WORDCOUNT"));
		facade.setExtractor(ExtractorFactory.getExtractor("FILE"));
		facade.setTransformers(lstTransformers);
		facade.setLoader(LoaderFactory.getLoader("FILE"));
		
		try {
			
			facade.extractTransformLoad(
					"D:\\betterjobworkspace\\crest\\trunk\\folder_1",
					"D:\\betterjobworkspace\\crest\\trunk\\folder_2");
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
	}

}
