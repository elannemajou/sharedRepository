package com.katas.question8;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Question8StaticTest {

	private final static int QUEUE_SIZE = 100;
	private final static int NB_ELEMENTS_TO_PRODUCE = 50;
	
	public static void main(String[] args) {
		 ExecutorService executorService = Executors.newFixedThreadPool(2);
		 BlockingQueue<Integer> sharedQueue = new ArrayBlockingQueue(QUEUE_SIZE);
		 
		 Thread prodThread = new Thread(new ProducerWithJava7(sharedQueue, NB_ELEMENTS_TO_PRODUCE), "Producer");
	     Thread consThread = new Thread(new ConsumerWithJava7(sharedQueue), "Consumer");
	     executorService.execute(prodThread);
	     executorService.execute(consThread);
	     executorService.shutdown();

	}

}
