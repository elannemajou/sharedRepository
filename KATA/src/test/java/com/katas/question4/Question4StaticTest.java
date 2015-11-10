package com.katas.question4;

import static com.katas.question4.FalseSharing.NUM_THREADS;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.katas.question4.FalseSharing;

public class Question4StaticTest {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(Question4StaticTest.class);
	
	public static void main(final String[] args) throws Exception
    {
        final long start = System.nanoTime();
        runTest();
        LOGGER.info("duration = " + (System.nanoTime() - start) + " ms");
    }
 
    private static void runTest() throws InterruptedException
    {
        Thread[] threads = new Thread[NUM_THREADS];
 
        for (int i = 0; i < threads.length; i++)
        {
            threads[i] = new Thread(new FalseSharing(i));
        }
 
        for (Thread t : threads)
        {
            t.start();
        }
 
        for (Thread t : threads)
        {
            t.join();
        }
    }
	
	
}
