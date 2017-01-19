package com.fizzbuzz.fb.service.impl;

import java.math.BigInteger;

import com.fizzbuzz.fb.service.FizzBuzzChain;

public class BuzzManipulateImpl implements FizzBuzzChain{

	public static BigInteger fizzBuzzVal = BigInteger.valueOf(5);
	
	private FizzBuzzChain fizzBuzzChain;
	
	@Override
	public String manipulateFizzBuzz(BigInteger val) {
		if((val.remainder(fizzBuzzVal))==BigInteger.ZERO){
			return "buzz";
		}else{
			return this.fizzBuzzChain.manipulateFizzBuzz(val);
		}
	}

	@Override
	public void moveToNextChain(FizzBuzzChain chain) {
		// TODO Auto-generated method stub
		this.fizzBuzzChain = chain;
	}

}
