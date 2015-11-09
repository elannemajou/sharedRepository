package com.katas.question13;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.katas.Question3;


public class Question13StaticTest {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(Question13StaticTest.class);
	
	public static void main(String[] args) {
		Runnable runnable1 = new Runnable(){
			public void run() {
				int id1 = ThreadId.get();
				LOGGER.info("Thread id is : " + id1);
			}
		};
		
		Runnable runnable2 = new Runnable(){
			public void run() {
				int id1 = ThreadIdWithoutThreadLocal.get();
				LOGGER.info("Thread id is : " + id1);
			}
		};
		
		Thread thread1 = new Thread(runnable1);
		Thread thread2 = new Thread(runnable1);
		Thread thread3 = new Thread(runnable1);
		
		Thread thread4 = new Thread(runnable2);
		Thread thread5 = new Thread(runnable2);
		Thread thread6 = new Thread(runnable2);

		thread1.start();
		thread2.start();
		thread3.start();
		
		thread4.start();
		thread5.start();
		thread6.start();
	}
}
