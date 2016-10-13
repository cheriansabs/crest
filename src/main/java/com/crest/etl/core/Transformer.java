package com.crest.etl.core;

import java.util.List;

public interface Transformer {
		
	List<String> transform(List<String> lst);
}
