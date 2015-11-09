package com.katas;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Question48 {

	private final static Logger LOGGER = LoggerFactory.getLogger(Question48.class);
	
	public void concatStringChannel(int nbRun, int nbConcat, List<String> stringToConcat){
		long start = System.currentTimeMillis();

	      for(int loop = 0 ; loop < nbRun; loop++){
	         String text = "";
	         for(int i = 0; i < nbConcat; i++){
	            text += stringToConcat.get(i % 10);
	         }
	      }
	      long end = System.currentTimeMillis();
	      LOGGER.info("String concatenation: "+(end-start)+" ms");
	}
	
	
	public void concatStringWithStringBuilder(int nbRun, int nbConcat, List<String> stringToConcat){
		long start = System.currentTimeMillis();

		for(int loop = 0 ; loop < nbRun; loop++){
	         StringBuilder text = new StringBuilder();
	         for(int i = 0; i < nbConcat; i++){
	            text.append(stringToConcat.get(i % 10));
	         }
	      }
	      long end = System.currentTimeMillis();
	      LOGGER.info("String concatenation: "+(end-start)+" ms");
	}
	
	
	public void concatStringWithStringBuffer(int nbRun, int nbConcat, List<String> stringToConcat){
		long start = System.currentTimeMillis();

		for(int loop = 0 ; loop < nbRun; loop++){
	         StringBuffer text = new StringBuffer();
	         for(int i = 0; i < nbConcat; i++){
	            text.append(stringToConcat.get(i % 10));
	         }
	      }
	      long end = System.currentTimeMillis();
	      LOGGER.info("String concatenation: "+(end-start)+" ms");
	}
	
	
	
	
	
}
