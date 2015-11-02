package com.katas.question8;

import java.util.Vector;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConsumerBeforeJava7 implements Runnable {

	private final static Logger LOGGER = LoggerFactory.getLogger(ConsumerBeforeJava7.class);
	
	private final Vector sharedQueue;

public ConsumerBeforeJava7(Vector sharedQueue) {
	this.sharedQueue = sharedQueue;
}

public void run() {
	while (true) {
		try {
			System.out.println("Consumed: " + consume());
			Thread.sleep(50);
		} catch (InterruptedException ex) {
			LOGGER.error(ex.getMessage());
		}

	}
}

private int consume() throws InterruptedException {
	//wait if queue is empty
	while (sharedQueue.isEmpty()) {
		synchronized (sharedQueue) {
			LOGGER.info("Queue is empty " + Thread.currentThread().getName()
					+ " is waiting , size: " + sharedQueue.size());

			sharedQueue.wait();
		}
	}

	//Otherwise consume element and notify waiting producer
	synchronized (sharedQueue) {
		Integer result = (Integer) sharedQueue.remove(0);
		sharedQueue.notifyAll();
		return result;
	}
}
}

