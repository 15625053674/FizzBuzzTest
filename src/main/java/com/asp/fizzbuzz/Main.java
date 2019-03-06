package com.asp.fizzbuzz;

import java.util.ArrayList;
import java.util.List;

import com.asp.fizzbuzz.enumeration.FizzBuzzStratageEnum;
import com.asp.fizzbuzz.service.FizzBuzzService;
import com.asp.fizzbuzz.service.IntegerToStringService;
import com.asp.fizzbuzz.service.impl.FizzBuzzServiceImpl;
import com.asp.fizzbuzz.service.impl.IntegerToBuzzServiceImpl;
import com.asp.fizzbuzz.service.impl.IntegerToFizzServiceImpl;

public class Main {

	public static void main(String[] args) {

		int n = 100;

		List<IntegerToStringService> integerToStringServiceList = new ArrayList<IntegerToStringService>();
		integerToStringServiceList.add(new IntegerToFizzServiceImpl());
		integerToStringServiceList.add(new IntegerToBuzzServiceImpl());

		FizzBuzzService fizzBuzzService = new FizzBuzzServiceImpl();

		ArrayList output = fizzBuzzService.output(100, integerToStringServiceList, FizzBuzzStratageEnum.APPEND_ALL_ASC);

		for (int i = 0; i < output.size(); i++) {
			System.out.println(output.get(i));
		}

	}

}
