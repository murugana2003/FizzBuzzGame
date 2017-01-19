package com.fizzbuzz.fb.service.impl;

import java.math.BigInteger;

import com.fizzbuzz.fb.service.FizzBuzzChain;

public class FizzManipulateImpl implements FizzBuzzChain{

	public static BigInteger fizzBuzzVal = BigInteger.valueOf(3);
	
	@Override
	public String manipulateFizzBuzz(BigInteger val) {
		if((val.remainder(fizzBuzzVal))==BigInteger.ZERO){
			return "fizz";
		}else{
			return val.toString();
		}
	}

	@Override
	public void moveToNextChain(FizzBuzzChain chain) {

	}

}
