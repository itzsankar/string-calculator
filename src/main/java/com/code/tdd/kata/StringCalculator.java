package com.code.tdd.kata;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringCalculator {
	public Integer add(String numbers) {
		List<Integer> splittedNumbers = Arrays.stream(numbers.split(","))
				.filter(str -> !str.isEmpty()).map(Integer::valueOf).collect(Collectors.toList());
		if(splittedNumbers.size() == 0) {
			return 0;
		}
		if(splittedNumbers.size() == 1) {
			return splittedNumbers.get(0);
		}
		return splittedNumbers.get(0)+ splittedNumbers.get(1);
	}

}
