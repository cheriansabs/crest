package com.crest.etl.core.impl;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import com.crest.etl.core.Transformer;

public class WordCountTransformer implements Transformer {

	@Override
	public List<String> transform(List<String> lst) {
		// TODO Auto-generated method stub
		Map<String, AtomicInteger> mapWordCount = new LinkedHashMap<>();
		for (String str : lst) {
			String[] words = str.split("\\W+");
			for (String word : words) {
				AtomicInteger count = mapWordCount.putIfAbsent(word, new AtomicInteger(1));
				if (count != null)
					count.incrementAndGet();
				/*
				 * if(mapWordCount.containsKey(word)) { Integer count =
				 * mapWordCount.get(word); count++; } else{ mapWordCount.pu }
				 */
			}
		}
		List<String> lstTransformedStrings = mapWordCount.entrySet().stream()
				.map(entry ->entry.getKey() + "=" + entry.getValue()+ ",").collect(Collectors.toList());

		return lstTransformedStrings;
	}

}
