package com.crest.etl.core;

import java.io.IOException;
import java.util.List;

public interface Loader {
	
	public void load(List<String> transformedValues,String... options) throws IOException;
	
}
