package com.fizzbuzz.fb.service.impl;

import static org.junit.Assert.*;

import java.math.BigInteger;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.fizzbuzz.fb.service.FizzBuzzChain;
import com.fizzbuzz.fb.service.impl.LuckyManipulateImpl;

@RunWith(PowerMockRunner.class)
@PrepareForTest(LuckyManipulateImpl.class)
public class LuckyManipulateImplTest {
	public static LuckyManipulateImpl luckyManipulate;

	@BeforeClass
	public static void setUpClass() {
		luckyManipulate = new LuckyManipulateImpl();
	}

	@Test
	public void testInstance_notNull() {
		assertNotNull(luckyManipulate);
	}

	@Test
	public void testInstance_val() throws Exception {
		FizzBuzzChain fizzBuzzChain = PowerMockito.mock(FizzBuzzChain.class);
		LuckyManipulateImpl mockFizzBuzz = PowerMockito.spy(luckyManipulate);
		mockFizzBuzz.moveToNextChain(fizzBuzzChain);
		mockFizzBuzz.manipulateFizzBuzz(BigInteger.ONE);
	    Mockito.verify(mockFizzBuzz, Mockito.times(1)).manipulateFizzBuzz(BigInteger.ONE);
	 }

	@Test
	public void testInstance_lucky() throws Exception {
		FizzBuzzChain fizzBuzzChain = PowerMockito.mock(FizzBuzzChain.class);
		LuckyManipulateImpl mockFizzBuzz = PowerMockito.spy(luckyManipulate);
		mockFizzBuzz.moveToNextChain(fizzBuzzChain);
		String fizz = mockFizzBuzz.manipulateFizzBuzz(BigInteger.valueOf(33));
	    assertEquals("lucky",fizz);
	}
	
	@Test
	public void testInstance_luckyOne() throws Exception {
		FizzBuzzChain fizzBuzzChain = PowerMockito.mock(FizzBuzzChain.class);
		LuckyManipulateImpl mockFizzBuzz = PowerMockito.spy(luckyManipulate);
		mockFizzBuzz.moveToNextChain(fizzBuzzChain);
		String fizz = mockFizzBuzz.manipulateFizzBuzz(BigInteger.valueOf(273));
	    assertEquals("lucky",fizz);
	}
	
	
	@AfterClass
	public static void tearDownClass() {
		luckyManipulate = null;
	}
}
