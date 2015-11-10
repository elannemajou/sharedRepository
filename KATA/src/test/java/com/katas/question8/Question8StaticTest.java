package com.katas.question8;

import java.util.Vector;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.katas.question8.ConsumerBeforeJava7;
import com.katas.question8.ConsumerWithJava7;
import com.katas.question8.ProducerBeforeJava7;
import com.katas.question8.ProducerWithJava7;

public class Question8StaticTest {

	private final static int QUEUE_SIZE = 100;
	private final static int NB_ELEMENTS_TO_PRODUCE = 50;
	private final static Logger LOGGER = LoggerFactory.getLogger(Question8StaticTest.class);
	
	public static void main(String[] args) {
		timeAndComputeBeforeJava7();
		timeAndComputeWithJava7();
	}
	
	public static void timeAndComputeBeforeJava7(){
		final long start = System.nanoTime();
		computeBeforeJava7();
		final long end = System.nanoTime();
		LOGGER.info("Time (second) before java 7 taken is " + (end-start)/1.0e9);
	}
	
	public static void timeAndComputeWithJava7(){
		final long start = System.nanoTime();
		computeWithJava7();
		final long end = System.nanoTime();
		LOGGER.info("Time (second) with java 7 taken is " + (end-start)/1.0e9);
	}
	
	
	public static void computeWithJava7(){
		 ExecutorService executorService = Executors.newFixedThreadPool(8);
		 BlockingQueue<Integer> sharedQueue = new ArrayBlockingQueue(QUEUE_SIZE);
		 
		 Thread prodThread = new Thread(new ProducerWithJava7(sharedQueue, NB_ELEMENTS_TO_PRODUCE), "Producer");
	     Thread consThread = new Thread(new ConsumerWithJava7(sharedQueue), "Consumer");
	     executorService.execute(prodThread);
	     executorService.execute(consThread);
	     executorService.shutdown();
	}
	
	public static void computeBeforeJava7(){
 		 Vector sharedQueue = new Vector();
		 
		 Thread prodThread = new Thread(new ProducerBeforeJava7(sharedQueue, QUEUE_SIZE, NB_ELEMENTS_TO_PRODUCE), "Producer");
	     Thread consThread = new Thread(new ConsumerBeforeJava7(sharedQueue), "Consumer");
	     prodThread.start();
	     consThread.start();
	}

}
