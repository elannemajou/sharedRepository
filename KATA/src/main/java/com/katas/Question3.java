package com.katas;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Question3 {
	
	public static String ENCODING = "UTF-8";

	private final static Logger LOGGER = LoggerFactory.getLogger(Question3.class);
	
	public static long getLongFromBytesWithString(byte[] sourceBytes){
		String longToGet = "0L";
		try {
			longToGet = new String(sourceBytes, ENCODING);
		} catch (UnsupportedEncodingException e) {
			LOGGER.error("cannot encode string with following encoder : " + ENCODING);
		}
		return Long.decode(longToGet);
	}
	
	public static long getLongFromBytesParsingString(byte[] sourceBytes){
		String longToGet = "0L";
		try {
			longToGet = new String(sourceBytes, ENCODING);
		} catch (UnsupportedEncodingException e) {
			LOGGER.error("cannot encode string with following encoder : " + ENCODING);
		}
		return Long.parseLong(longToGet);
	}
	
	public static long getLongFromBytesWithByteBuffer(byte[] sourceBytes){
		ByteBuffer bb = ByteBuffer.allocate(1024);
		bb.put(sourceBytes,0, sourceBytes.length);
		return bb.getLong();
	}
	
}
