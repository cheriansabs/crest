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

public class TestETL {

	@Test
	public void testCapitalization() {

		Facade facade = FacadeFactory.getExtractor("FILE");
		List<Transformer> lstTransformers = new ArrayList<>();
		lstTransformers.add(TransformerFactory.getTransformer("CAPITALIZE"));
		facade.setExtractor(ExtractorFactory.getExtractor("FILE"));
		facade.setTransformers(lstTransformers);
		facade.setLoader(LoaderFactory.getLoader("FILE"));

		try {
			//Replace params with input dir and output dir
			facade.extractTransformLoad(
					"F:\\tmp\\folder_1",
					"F:\\tmp\\folder_2");
			
			//Replace param 1 with output dir
			Assert.assertTrue(TestUtil
					.checkIfFilesAreCapitalized("F:\\tmp\\folder_2"));
			System.out.println("successfully capitalized");

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}
