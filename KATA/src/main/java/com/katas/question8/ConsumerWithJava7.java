package com.katas.question8;

import java.util.concurrent.BlockingQueue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConsumerWithJava7 implements Runnable {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(ConsumerWithJava7.class);

	private final BlockingQueue<Integer> sharedQueue;

	public ConsumerWithJava7(BlockingQueue<Integer> sharedQueue) {
		this.sharedQueue = sharedQueue;
	}

	public void run() {
		while (true) {
			try {
				LOGGER.info("Consumed: " + consume());
			} catch (InterruptedException ex) {
				LOGGER.error(ex.getMessage());
			}

		}
	}

	private int consume() throws InterruptedException {
		return sharedQueue.take();
	}
}

