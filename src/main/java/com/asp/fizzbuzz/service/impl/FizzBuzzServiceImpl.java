package com.asp.fizzbuzz.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.asp.fizzbuzz.enumeration.FizzBuzzStratageEnum;
import com.asp.fizzbuzz.exception.FizzBuzzException;
import com.asp.fizzbuzz.service.FizzBuzzService;
import com.asp.fizzbuzz.service.IntegerToStringService;

public class FizzBuzzServiceImpl implements FizzBuzzService {

	public ArrayList output(int n, List<IntegerToStringService> integerToStringServiceList,
							FizzBuzzStratageEnum fizzBuzzStratage) {
		ArrayList list = new ArrayList();
		StringBuffer result = null;
		for (int i = 1; i <= n; i++) {
			result = new StringBuffer();
			if (FizzBuzzStratageEnum.APPEND_ALL_ASC.getCode().equals(fizzBuzzStratage.getCode())) {
				for (IntegerToStringService calcService : integerToStringServiceList) {
					if (calcService.support(i)) {
						result.append(calcService.transfer(i));
					}
				}
				if (0 == result.length()) {
					result.append(String.valueOf(i));
				}
				list.add(result.toString());
			}else{
				throw new FizzBuzzException(
						String.format("Unsupported FizzBuzzStratageEnum(%s)", fizzBuzzStratage.getCode()));
			}
		}

		return list;
	}
}
