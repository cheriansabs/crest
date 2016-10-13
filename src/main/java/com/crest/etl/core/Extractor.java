package com.crest.etl.core;

import java.util.List;

public interface Extractor<P> {

	List<String> extract(P param) throws Exception;

}
