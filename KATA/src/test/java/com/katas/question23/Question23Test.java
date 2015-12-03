package com.katas.question23;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.HashMap;

import org.junit.Test;

public class Question23Test {

	@Test
	public void testWithGoodApple() {
		HashMap<GoodApple, String> appleMap = new HashMap<GoodApple, String>();
		GoodApple a1 = new GoodApple("green");
		GoodApple a2 = new GoodApple("red");
		GoodApple a3 = new GoodApple("green");
		
		appleMap.put(a1, "test1value");
		appleMap.put(a2, "test2value");
		
		
		assertEquals("test1value", (String) appleMap.get(a3));
	}
	
	@Test
	public void testWithBadApple() {
		HashMap<BadApple, String> appleMap = new HashMap<BadApple, String>(); 
		
		BadApple a1 = new BadApple("green");
		appleMap.put(a1, "test1value");
		
		BadApple a2 = new BadApple("red");
		appleMap.put(a2, "test2value");
		
		BadApple a3 = new BadApple("green");
		
		assertNotEquals("test1value", (String) appleMap.get(a3));
	}

}
