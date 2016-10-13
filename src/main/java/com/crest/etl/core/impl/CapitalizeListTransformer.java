package com.crest.etl.core.impl;

import java.util.List;

import com.crest.etl.core.Transformer;

public class CapitalizeListTransformer  implements  Transformer{

	@Override
	public List<String> transform(List<String> lst) {
		 lst.replaceAll(String::toUpperCase);
		 return lst;
	}

}
