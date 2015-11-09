package com.katas;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class Question48Test {
	
	private static final int NB_CONCAT = 1000;
	private static final int NB_RUN = 1000;

	private static List<String> TOKENS = Arrays.asList("zero", "one", "thow", "three", "four", "five", "six", "seven", "eight", "nine");
	

	@Test
	public void testConcatStringChannel() {
		Question48 q48 = new Question48();
		q48.concatStringChannel(NB_RUN, NB_CONCAT, TOKENS);
	}

	@Test
	public void testConcatStringWithStringBuilder() {
		Question48 q48 = new Question48();
		q48.concatStringWithStringBuilder(NB_RUN, NB_CONCAT, TOKENS);
	}

	@Test
	public void testConcatStringWithStringBuffer() {
	   Question48 q48 = new Question48();
	   q48.concatStringWithStringBuffer(NB_RUN, NB_CONCAT, TOKENS);
	}

}
