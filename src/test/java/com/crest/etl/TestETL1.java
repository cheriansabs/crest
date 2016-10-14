package com.crest.etl;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
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
			//Replace params with input dir and output dir
			facade.extractTransformLoad(
					"F:\\tmp\\folder_3",
					"F:\\tmp\\folder_4");
			
			//Replace param 1 with output dir
			Assert.assertTrue(TestUtil
					.checkWordCount("F:\\tmp\\folder_4","abc=3,bcd=2,xyz=2,pqr=2,poo=2,zoo=2,roo=1,querty=1,"));
			System.out.println("successfully got word count");
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
	}

}
