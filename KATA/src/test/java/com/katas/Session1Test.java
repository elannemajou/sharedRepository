package com.katas;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Session1Test {

	@Test
	public void testSucessfullyGetLongFromBytesWithString() {
		long longToGet = 12L;
		byte[] longBytes = String.valueOf(longToGet).getBytes();
		assertEquals(Session1.getLongFromBytesWithString(longBytes), longToGet);
	}
	
	@Test(expected=NumberFormatException.class)
	public void testFailedToGetLongFromBytesWithString() {
		long longToGet = 12L;
		byte[] longBytes = "toto".getBytes();
		assertEquals(Session1.getLongFromBytesWithString(longBytes), longToGet);
	}
	
	@Test
	public void testSucessfullyGetLongFromBytesWithByteBuffer() {
		long longToGet = 12L;
		byte[] longBytes = String.valueOf(longToGet).getBytes();
		assertEquals(Session1.getLongFromBytesWithByteBuffer(longBytes), longToGet);
	}
	

}
