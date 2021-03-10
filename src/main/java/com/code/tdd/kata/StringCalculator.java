package com.code.tdd.kata;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringCalculator {
	public Integer add(String numbers) {
		String delimiter = ",";
		if(numbers.matches("//(.*)\n(.*)")){
			delimiter = Character.toString(numbers.charAt(2));
			numbers = numbers.substring(4);
		}
		List<Integer> splittedNumbers = new ArrayList<>();
		List<Integer> negNumbers = new ArrayList<>();
		Arrays.stream(numbers.split(delimiter+"|\n"))
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

}
