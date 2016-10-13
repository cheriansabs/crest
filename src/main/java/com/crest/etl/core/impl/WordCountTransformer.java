package com.crest.etl.core.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.crest.etl.core.Transformer;

public class WordCountTransformer implements Transformer {

	@Override
	public List<String> transform(List<String> lst) {
		// TODO Auto-generated method stub
		Map<String, Integer> mapWordCount = new HashMap<>();
		for (String str : lst) {
			String[] words = str.split("\\W+");
			for (String word : words) {
				Integer count = mapWordCount.putIfAbsent(word, 1);
				if (count != null)
					count++;
				/*
				 * if(mapWordCount.containsKey(word)) { Integer count =
				 * mapWordCount.get(word); count++; } else{ mapWordCount.pu }
				 */
			}
		}
		List<String> lstTransformedStrings = mapWordCount.entrySet().stream()
				.map(entry -> entry.getKey() + "  " + entry.getValue()).collect(Collectors.toList());

		return lstTransformedStrings;
	}

}
