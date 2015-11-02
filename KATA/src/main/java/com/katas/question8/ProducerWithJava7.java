package com.katas.question8;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProducerWithJava7 implements Runnable {

	private final static Logger LOGGER = LoggerFactory.getLogger(ProducerWithJava7.class);

	private final BlockingQueue<Integer> sharedQueue;
	private final int nbElementsToProduce;

	public ProducerWithJava7(BlockingQueue<Integer> sharedQueue, int nbElementsToProduce) {
		this.sharedQueue = sharedQueue;
		this.nbElementsToProduce = nbElementsToProduce;
	}

	public void run() {
		AtomicInteger i = new AtomicInteger(0);
		while (i.get() < nbElementsToProduce){
			i.incrementAndGet();
			LOGGER.info("Produced: " + i.get());
			try {
				produce(i.get());
			} catch (InterruptedException ex) {
				LOGGER.error(ex.getMessage());
			}
		}
		LOGGER.info("Queue size is : " + sharedQueue.size());
	}


	private void produce(int i) throws InterruptedException {
		sharedQueue.put(Integer.valueOf(i));
	}
}



