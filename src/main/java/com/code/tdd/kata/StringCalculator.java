package com.code.tdd.kata;

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
		List<Integer> splittedNumbers = Arrays.stream(numbers.split(delimiter+"|\n"))
				.filter(str -> !str.isEmpty()).map(Integer::valueOf).collect(Collectors.toList());
		return splittedNumbers.stream().mapToInt(Integer::intValue).sum();
	}

}
