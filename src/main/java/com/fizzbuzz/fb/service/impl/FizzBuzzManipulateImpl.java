package com.fizzbuzz.fb.service.impl;

import java.math.BigInteger;

import com.fizzbuzz.fb.service.FizzBuzzChain;

public class FizzBuzzManipulateImpl implements FizzBuzzChain {

	public static BigInteger fizzBuzzVal = BigInteger.valueOf(15);
	
	private FizzBuzzChain fizzBuzzChain;
	
	@Override
	public String manipulateFizzBuzz(BigInteger val) {
		if((val.remainder(fizzBuzzVal))==BigInteger.ZERO){
			return "fizzbuzz";
		}else{
			return this.fizzBuzzChain.manipulateFizzBuzz(val);
		}
	}

	@Override
	public void moveToNextChain(FizzBuzzChain chain) {
		this.fizzBuzzChain = chain;
	}
}
