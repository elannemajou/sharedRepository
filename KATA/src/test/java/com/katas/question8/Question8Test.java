package com.katas.question8;

import java.util.Vector;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.Test;

public class Question8Test {
	
	private final int queueSize = 100;
	private final int nbElementToProduce = 50;
	
	@Test
	public void testProducerAndConsumerWithJava7(){
		 ExecutorService executorService = Executors.newFixedThreadPool(1);
		 BlockingQueue<Integer> sharedQueue = new ArrayBlockingQueue(queueSize);
		 
		 Thread prodThread = new Thread(new ProducerWithJava7(sharedQueue, nbElementToProduce), "Producer");
	     Thread consThread = new Thread(new ConsumerWithJava7(sharedQueue), "Consumer");
	     executorService.execute(prodThread);
	     //executorService.execute(consThread);
	     executorService.shutdown();
	}

}
