package com.crest.etl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.crest.etl.core.Facade;
import com.crest.etl.core.Transformer;
import com.crest.etl.factory.ExtractorFactory;
import com.crest.etl.factory.LoaderFactory;
import com.crest.etl.factory.TransformerFactory;

public class TestETL {

	@Test
	public void testCapitalization() {
		
		Facade extractor = ExtractorFactory.getExtractor("FILE");
		List<Transformer> lstTransformers = new ArrayList<>();
		lstTransformers.add(TransformerFactory.getTransformer("CAPITALIZE"));
		extractor.setTransformers(lstTransformers);
		extractor.setLoader(LoaderFactory.getLoader("FILE"));
		
		try {
			
			extractor.extractTransformLoad("F:\\tmp\\folder_1","F:\\tmp\\folder_2");
			Assert.assertTrue(TestUtil.checkIfFilesAreCapitalized("F:\\tmp\\folder_2"));
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
	}
	
	
	/*@Test
	public void testWordCount() {
		
		Extractor extractor = ExtractorFactory.getExtractor("FILE");
		List<Transformer> lstTransformers = new ArrayList<>();
		lstTransformers.add(TransformerFactory.getTransformer("WORDCOUNT"));
		extractor.setTransformers(lstTransformers);
		extractor.setLoader(LoaderFactory.getLoader("FILE"));
		
		try {
			
			extractor.extract("F:\\tmp\\folder_1","F:\\tmp\\folder_2");
			
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
	}*/

}
