package com.katas;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Question3Test {

	@Test
	public void testSucessfullyGetLongFromBytesWithString() {
		long longToGet = 12L;
		byte[] longBytes = String.valueOf(longToGet).getBytes();
		assertEquals(Question3.getLongFromBytesWithString(longBytes), longToGet);
	}
	
	@Test(expected=NumberFormatException.class)
	public void testFailedToGetLongFromBytesWithString() {
		long longToGet = 12L;
		byte[] longBytes = "toto".getBytes();
		assertEquals(Question3.getLongFromBytesWithString(longBytes), longToGet);
	}
	
	@Test
	public void testSucessfullyGetLongFromBytesWithByteBuffer() {
		long longToGet = 12L;
		byte[] longBytes = String.valueOf(longToGet).getBytes();
		assertEquals(Question3.getLongFromBytesWithByteBuffer(longBytes), longToGet);
	}
	
	@Test
	public void testSucessfullyGetLongFromBytesParsingString() {
		long longToGet = 12L;
		byte[] longBytes = String.valueOf(longToGet).getBytes();
		assertEquals(Question3.getLongFromBytesParsingString(longBytes), longToGet);
	}
	

}
