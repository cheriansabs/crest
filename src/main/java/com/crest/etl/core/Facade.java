package com.crest.etl.core;

import java.util.List;

public interface Facade<P> {
	

	public void extractTransformLoad(String... options) throws  Exception;

	public void setTransformers(List<Transformer> lstTransformers);

	public void setLoader(Loader loader);

	public void setExtractor(Extractor<P> extractor);
	
	
}
