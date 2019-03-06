package com.asp.fizzbuzz.service.impl;

import com.asp.fizzbuzz.constant.Constant;
import com.asp.fizzbuzz.service.IntegerToStringService;

/**
 * IntegerToStringService implementation for BUZZ case.
 * @author hp
 */
public class IntegerToBuzzServiceImpl implements IntegerToStringService {

	public String transfer(int n) {
		return Constant.BUZZ;
	}

	public boolean support(int n) {
		return 0 == n%5 || String.valueOf(n).contains("5");
	}

}
