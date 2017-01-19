package com.fizzbuzz.fb.service.impl;

import java.math.BigInteger;

import com.fizzbuzz.fb.service.FizzBuzzChain;

public class LuckyManipulateImpl implements FizzBuzzChain{

	private FizzBuzzChain fizzBuzzChain;
	
	@Override
	public String manipulateFizzBuzz(BigInteger val) {
		String strval = val.toString();
		if(strval.contains("3")){
			return "lucky";
		}else{
			return this.fizzBuzzChain.manipulateFizzBuzz(val);
		}
	}

	@Override
	public void moveToNextChain(FizzBuzzChain chain) {
		this.fizzBuzzChain = chain;
	}

}
