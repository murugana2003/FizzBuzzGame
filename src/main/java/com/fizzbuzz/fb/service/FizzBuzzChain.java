package com.fizzbuzz.fb.service;

import java.math.BigInteger;

public interface FizzBuzzChain {

	public String manipulateFizzBuzz(BigInteger val);
	
	public void moveToNextChain(FizzBuzzChain chain);
}
