package com.crest.etl.core.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.crest.etl.core.Extractor;
import com.crest.etl.core.Facade;
import com.crest.etl.core.Loader;
import com.crest.etl.core.Transformer;
import com.crest.etl.util.FileUtils;

public class FileFacade implements Facade {

	List<Transformer> lstTransformers;
	List<String> lstTransformedStrings;
	Loader loader;
	Extractor extractor;

	@Override
	public void extractTransformLoad(String... options) throws Exception {

		String filePath = options[0];
		String outputDirectory = options[1];
		if ((filePath != null) && outputDirectory != null) {

			File[] files = FileUtils.getFiles(filePath);
			for (File file : files) {

				List<String> list = extractor.extract(file);

				lstTransformedStrings = list;
				lstTransformers.forEach(transformer -> {
					lstTransformedStrings = transformer.transform(lstTransformedStrings);

				});
				loader.load(lstTransformedStrings, outputDirectory, file.getName());

			}
		} else {

		}

	}

	@Override
	public void setTransformers(List<Transformer> lstTransformers) {
		this.lstTransformers = lstTransformers;

	}

	@Override
	public void setLoader(Loader loader) {
		this.loader = loader;

	}

}
