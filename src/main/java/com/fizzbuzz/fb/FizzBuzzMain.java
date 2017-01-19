package com.fizzbuzz.fb;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fizzbuzz.fb.service.FizzBuzzChain;
import com.fizzbuzz.fb.service.impl.BuzzManipulateImpl;
import com.fizzbuzz.fb.service.impl.FizzBuzzManipulateImpl;
import com.fizzbuzz.fb.service.impl.FizzManipulateImpl;
import com.fizzbuzz.fb.service.impl.LuckyManipulateImpl;

/**
 * Main class to initiate the FizzBuzzGame.
 * 1. Implemented COR (Chains of Responsibility) pattern
 * 2. Kickstart Method triggers the chain
 * 3. Plan to call kickstart method using RestApi
 * 
 * @author mamulraj
 */
public class FizzBuzzMain {
	
	private FizzBuzzChain fizzLuckyChain;

	public FizzBuzzMain() {
		// initialize the chain
		this.fizzLuckyChain = new LuckyManipulateImpl();
		FizzBuzzChain fizzBuzzChain = new FizzBuzzManipulateImpl();
		FizzBuzzChain buzzChain = new BuzzManipulateImpl();
		FizzBuzzChain fizzChain = new FizzManipulateImpl();

		// set the chain of responsibility
		fizzLuckyChain.moveToNextChain(fizzBuzzChain);
		fizzBuzzChain.moveToNextChain(buzzChain);
		buzzChain.moveToNextChain(fizzChain);
	}
	
	/**
	 * Kickstart method triggers the Chain
	 * 
	 * @param startRange
	 * @param endRange
	 * @return
	 */
	public String kickStart(int startRange, int endRange) {

		StringBuffer appendval = new StringBuffer();
		String finalString = new String();
		if(startRange>0 && endRange>0 && (endRange>=startRange)){
		for (int i = startRange; i <= endRange; i++) {
			String append = fizzLuckyChain.manipulateFizzBuzz(BigInteger.valueOf(i));
			appendval.append(append).append(" ");
		}
		String beforeCount = appendval.toString().trim();
		System.out.println("Before count Final String :::" + beforeCount);
		String afterCount = count(beforeCount);
		System.out.println("Includes count Final String :::" + afterCount);
		finalString = appendval.append("\n").append(afterCount).toString().trim();
		}
		return finalString;
	}
	
	/**
	 * Counts number of time Fizz, buzz, lucky values appeared.
	 * 
	 * @param val
	 * @return
	 */
	public String count(String val){
		
		List<String> list = Arrays.asList(val.split(" "));
		 
        Set<String> uniqueWords = new HashSet<String>(list);
        
        int fizCount =0;
        int buzzCount = 0;
        int fizzBuzzCount = 0;
        int luckyCount = 0;
        int intCount=0;
        for (String string : uniqueWords) {
        	
        	if(string.equalsIgnoreCase("Fizz")){
        		fizCount = Collections.frequency(list, string);
        	}else if(string.equalsIgnoreCase("Buzz")){
        		buzzCount = Collections.frequency(list, string);
        	}else if (string.equalsIgnoreCase("FizzBuzz")){
        		fizzBuzzCount = Collections.frequency(list, string);
        	}else if (string.equalsIgnoreCase("Lucky")){
        		luckyCount = Collections.frequency(list, string);
        	}else{
        		intCount++;
        	}
			
		}
		
        StringBuffer buffer = new StringBuffer();
        buffer.append("Fizz ::").append(fizCount).append(" ").
        append("Buzz ::").append(buzzCount).append(" ").
        append("FizzBuzz ::").append(fizzBuzzCount).append(" ").
        append("Lucky ::").append(luckyCount).append(" ").
        append("Integer ::").append(intCount);
        
		return buffer.toString();
	}
}
