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
	
	/*
	 *  "1,2,3"        -> 6
	 *  "1,5,7,8,25"   -> 46
	 */
	@Test
	public void addUnknownNumbersTest() {
		StringCalculator stringCalc = new StringCalculator();
		assertEquals(Integer.valueOf(6), stringCalc.add("1,2,3"));
		assertEquals(Integer.valueOf(46), stringCalc.add("1,5,7,8,25"));
	}
	
	/*
	 *  "1\n2,3" -> 6
	 *  "1,\n"   -> 1
	 */
	@Test
	public void addnewlineNumbersTest() {
		StringCalculator stringCalc = new StringCalculator();
		assertEquals(Integer.valueOf(6), stringCalc.add("1\n2,3"));
		assertEquals(Integer.valueOf(1), stringCalc.add("1,\n"));
	}
}
