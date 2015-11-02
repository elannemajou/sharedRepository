package com.katas.question8;

import java.util.Vector;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.Test;

public class Question8Beforejava7Test {
	
	private final int queueSize = 100;
	private final int nbElementToProduce = 50;
		
	@Test
	public void testProducerAndConsumerBeforeJava7(){
        Vector sharedQueue = new Vector();
        
        Thread prodThread = new Thread(new ProducerBeforeJava7(sharedQueue, queueSize, nbElementToProduce), "Producer");
        Thread consThread = new Thread(new ConsumerBeforeJava7(sharedQueue), "Consumer");
        prodThread.start();
        consThread.start();
    }

}
