package com.code.tdd.kata;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringCalculator {
	public Integer add(String numbers) {
		List<Integer> splittedNumbers = Arrays.stream(numbers.split(",|\n"))
				.filter(str -> !str.isEmpty()).map(Integer::valueOf).collect(Collectors.toList());
		return splittedNumbers.stream().mapToInt(Integer::intValue).sum();
	}

}
