package com.fizzbuzz.fb;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.modules.junit4.PowerMockRunner;

import com.fizzbuzz.fb.FizzBuzzMain;

@RunWith(PowerMockRunner.class)
public class FizzBuzzMainTest {

	public static FizzBuzzMain fizzBuzzMain;
	
	@BeforeClass
	public static void setUpClass() {
		fizzBuzzMain = new FizzBuzzMain();
	}
	
	@Test
	public void testInstance_notNull(){
		assertNotNull(fizzBuzzMain);
	}
	
	@Test
	public void testStart_EndRange_notNull(){
		assertNotNull(fizzBuzzMain.kickStart(0, 0));
	}
	
	@Test
	public void testStart_EndRange(){
		assertTrue(fizzBuzzMain.kickStart(0, 0).isEmpty());
	}
	
	@Test
	public void testStartGreat_EndRange(){
		assertTrue(fizzBuzzMain.kickStart(1, 0).isEmpty());
	}
	
	@Test
	public void testStartless_EndRange(){
		assertTrue(fizzBuzzMain.kickStart(0, 1).isEmpty());
	}
	
	@Test
	public void testStart_EndRange_one(){
		FizzBuzzMain fizzBuzzMainTest = PowerMockito.spy(fizzBuzzMain);
		PowerMockito.when(fizzBuzzMainTest.count(Mockito.anyString())).thenReturn("");
		assertFalse(fizzBuzzMainTest.kickStart(1, 3).isEmpty());
		assertEquals("1 2 lucky",fizzBuzzMainTest.kickStart(1, 3));
	}
	
	@Test
	public void testStart_EndRange_two(){
		FizzBuzzMain fizzBuzzMainTest = PowerMockito.spy(fizzBuzzMain);
		PowerMockito.when(fizzBuzzMainTest.count(Mockito.anyString())).thenReturn("");
		assertFalse(fizzBuzzMainTest.kickStart(1, 5).isEmpty());
		assertEquals("1 2 lucky 4 buzz",fizzBuzzMainTest.kickStart(1, 5));
	}
	
	@Test
	public void testStart_EndRange_withoutCount(){
		FizzBuzzMain fizzBuzzMainTest = PowerMockito.spy(fizzBuzzMain);
		PowerMockito.when(fizzBuzzMainTest.count(Mockito.anyString())).thenReturn("");
		String kickStart = fizzBuzzMainTest.kickStart(1, 20);
		assertEquals("1 2 lucky 4 buzz fizz 7 8 fizz buzz 11 fizz lucky 14 fizzbuzz 16 17 fizz 19 buzz",kickStart);
	}
	
	@Test
	public void testStart_EndRange_withCount(){
		String kickStart = fizzBuzzMain.kickStart(1, 20);
		assertFalse(kickStart.isEmpty());
		String countStr = "1 2 lucky 4 buzz fizz 7 8 fizz buzz 11 fizz lucky 14 fizzbuzz 16 17 fizz 19 buzz "
				+"\n"+
				"Fizz ::4 Buzz ::3 FizzBuzz ::1 Lucky ::2 Integer ::10";
		assertEquals(countStr,kickStart);
	}
	
	@Test
	public void testStart_EndRange_any(){
		String kickStart = fizzBuzzMain.kickStart(30, 35);
		String countStr = "lucky lucky lucky lucky lucky lucky "
				+"\n"+
				"Fizz ::0 Buzz ::0 FizzBuzz ::0 Lucky ::6 Integer ::0";
		assertEquals(countStr,kickStart);
		
	}
	
	@AfterClass
	public static void tearDownClass() {
		fizzBuzzMain = null;
	}
}
