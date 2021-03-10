package com.code.tdd.kata;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringCalculator {
	public Integer add(String numbers) {
		List<Integer> splittedNumbers = new ArrayList<>();
		List<Integer> negNumbers = new ArrayList<>();
		Map<String,String> numAndDelimeter = this.getNumberAndDelimeter(numbers);
		Arrays.stream(numAndDelimeter.get("numbers")
				.split(numAndDelimeter.get("delimiter")+"|\n"))
		.filter(str -> !str.isEmpty())
		.map(Integer::valueOf)
		.filter(num -> num<1000)
		.forEach(val->{
			if(val>0) {
				splittedNumbers.add(val);
			} else {
				negNumbers.add(val);
			}
		});
		if(negNumbers.size() > 0) {
			throw new IllegalArgumentException("Negatives not allowed: " + negNumbers.stream().map(String::valueOf)
					.collect(Collectors.joining(",")));
		}
		return splittedNumbers.stream().mapToInt(Integer::intValue).sum();
	}
	private Map<String,String> getNumberAndDelimeter(String numbers){
		Map<String,String> result = new HashMap<>();
		String delimiter = ",";
		if(numbers.matches("//(.*)\n(.*)")){
			delimiter = "";
			Pattern p = Pattern.compile("\\[(.*?)\\]");
			Matcher m = p.matcher(numbers);
			if(numbers.indexOf("[") == -1) {
				delimiter = numbers.substring(2,numbers.indexOf("\n"));
			} else {
				while(m.find()) {
					if(delimiter == "") {
						delimiter = "\\"+m.group(1);
					} else {
						delimiter = delimiter+"|"+"\\"+m.group(1);
					}

				}
			}
			numbers = numbers.substring(numbers.indexOf("\n"));
		}
		result.put("numbers", numbers);
		result.put("delimiter", delimiter);
		return result;
	}

}
