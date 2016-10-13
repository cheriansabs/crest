package com.crest.etl.core;

import java.util.List;

public interface Facade {

	public void extractTransformLoad(String... options) throws  Exception;

	public void setTransformers(List<Transformer> lstTransformers);

	public void setLoader(Loader loader);
	
	
}
