package com.crest.etl.core;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface Extractor {

	public void extract(String... options) throws FileNotFoundException, IOException;

	public void setTransformers(List<Transformer> lstTransformers);

	public void setLoader(Loader loader);
	
	
}
