package com.fizzbuzz.fb.service.impl;

import static org.junit.Assert.*;

import java.math.BigInteger;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.fizzbuzz.fb.service.impl.FizzManipulateImpl;

public class FizzManipulateImplTest {
	public static FizzManipulateImpl fizzManipulate;

	@BeforeClass
	public static void setUpClass() {
		fizzManipulate = new FizzManipulateImpl();
	}

	@Test
	public void testInstance_notNull() {
		assertNotNull(fizzManipulate);
	}
	
	@Test
	public void testInstance_val() throws Exception {
		String fizz = fizzManipulate.manipulateFizzBuzz(BigInteger.ONE);
		assertEquals("1",fizz);
	}
	
	@Test
	public void testInstance_valOne() throws Exception {
		String fizz = fizzManipulate.manipulateFizzBuzz(BigInteger.valueOf(3));
		assertEquals("fizz",fizz);
	}
	
	@Test
	public void testInstance_valtwo() throws Exception {
		String fizz = fizzManipulate.manipulateFizzBuzz(BigInteger.valueOf(12));
		assertEquals("fizz",fizz);
	}
	
	@Test
	public void testInstance_valthree() throws Exception {
		String fizz = fizzManipulate.manipulateFizzBuzz(BigInteger.valueOf(10));
		assertEquals("10",fizz);
	}
	
	@AfterClass
	public static void tearDownClass() {
		fizzManipulate = null;
	}


}
