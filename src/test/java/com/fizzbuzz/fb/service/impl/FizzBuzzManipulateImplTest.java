package com.fizzbuzz.fb.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

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
import com.fizzbuzz.fb.service.impl.FizzBuzzManipulateImpl;

@RunWith(PowerMockRunner.class)
@PrepareForTest(FizzBuzzManipulateImpl.class)
public class FizzBuzzManipulateImplTest {

	public static FizzBuzzManipulateImpl fizzBuzzManipulate;

	@BeforeClass
	public static void setUpClass() {
		fizzBuzzManipulate = new FizzBuzzManipulateImpl();
	}

	@Test
	public void testInstance_notNull() {
		assertNotNull(fizzBuzzManipulate);
	}

	@Test
	public void testInstance_val() throws Exception {
		FizzBuzzChain fizzBuzzChain = PowerMockito.mock(FizzBuzzChain.class);
		FizzBuzzManipulateImpl mockFizzBuzz = PowerMockito.spy(fizzBuzzManipulate);
		mockFizzBuzz.moveToNextChain(fizzBuzzChain);
		mockFizzBuzz.manipulateFizzBuzz(BigInteger.ONE);
	    Mockito.verify(mockFizzBuzz, Mockito.times(1)).manipulateFizzBuzz(BigInteger.ONE);
	 }

	@Test
	public void testInstance_fizz() throws Exception {
		FizzBuzzChain fizzBuzzChain = PowerMockito.mock(FizzBuzzChain.class);
		FizzBuzzManipulateImpl mockFizzBuzz = PowerMockito.spy(fizzBuzzManipulate);
		mockFizzBuzz.moveToNextChain(fizzBuzzChain);
		String fizz = mockFizzBuzz.manipulateFizzBuzz(BigInteger.valueOf(15));
	    assertEquals("fizzbuzz",fizz);
	 }
	
	@AfterClass
	public static void tearDownClass() {
		fizzBuzzManipulate = null;
	}
}
