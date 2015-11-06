package com.katas;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.HashMap;

import org.junit.Test;

public class Question23Test {

	@Test
	public void testWithGoodHashCode() {
		HashMap<String, String> stringMap = new HashMap<String, String>(); 
		stringMap.put("Test1Key", "test1value");
		assertEquals("test1value", (String) stringMap.get("Test1Key"));
	}
	
	@Test
	public void testWithChangedHashCode() {
		HashMap<Question23, String> stringMap = new HashMap<Question23, String>(); 
		
		Question23 q1 = new Question23();
		q1.setInternalValue("Test1Value");
		stringMap.put(q1, "test1value");
		
		Question23 q2 = new Question23();
		q2.setInternalValue("Test1Value");
		stringMap.put(q2, "test2value");
		
		assertNotEquals("test1Value", (String) stringMap.get(q1));
	}

}
