package com.code.tdd.kata;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class StringCalculatorTest {
	
	/*
	 *  ""     -> 0
	 *  "1"    -> 1
	 *  "1,2"  -> 3
	 */
	@Test
	public void addUptotwoNumbersTest() {
		StringCalculator stringCalc = new StringCalculator();
		assertEquals(Integer.valueOf(0), stringCalc.add(""));
		assertEquals(Integer.valueOf(1), stringCalc.add("1"));
		assertEquals(Integer.valueOf(3), stringCalc.add("1,2"));
		
	}
}
