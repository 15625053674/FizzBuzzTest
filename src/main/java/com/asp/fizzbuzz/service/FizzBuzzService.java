package com.asp.fizzbuzz.service;

import java.util.ArrayList;
import java.util.List;

import com.asp.fizzbuzz.enumeration.FizzBuzzStratageEnum;

public interface FizzBuzzService {

	/**
	 * Final output list for a given integer n
	 * @param n A given integer
	 * @param integerToStringServiceList An ordered list in which each element represents an method for integer output
	 * @param fizzBuzzStratage The output stratage if a given integer satisfies different output methods
	 * @return
	 */
	public ArrayList output(int n, List<IntegerToStringService> integerToStringServiceList, FizzBuzzStratageEnum fizzBuzzStratage);
}
