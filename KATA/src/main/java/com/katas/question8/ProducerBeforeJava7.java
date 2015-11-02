package com.katas.question8;

import java.util.Vector;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProducerBeforeJava7 implements Runnable {

	private final static Logger LOGGER = LoggerFactory.getLogger(ProducerBeforeJava7.class);
	
	private final Vector sharedQueue;
	private final int queueMaxSize;
	private final int nbElementsToProduce;

	public ProducerBeforeJava7(Vector sharedQueue, int size, int nbElementsToProduce) {
		this.sharedQueue = sharedQueue;
		this.queueMaxSize = size;
		this.nbElementsToProduce = nbElementsToProduce;
	}

	public void run() {
		for (int i = 0; i < nbElementsToProduce; i++) {
			System.out.println("Produced: " + i);
			try {
				produce(i);
			} catch (InterruptedException ex) {
				LOGGER.error(ex.getMessage());
			}

		}
	}

	private void produce(int i) throws InterruptedException {

		//wait if queue is full
		while (sharedQueue.size() == queueMaxSize) {
			synchronized (sharedQueue) {
				LOGGER.info("Queue is full " + Thread.currentThread().getName()
						+ " is waiting , size: " + sharedQueue.size());

				sharedQueue.wait();
			}
		}

		//producing element and notify consumers
		synchronized (sharedQueue) {
			sharedQueue.add(i);
			sharedQueue.notifyAll();
		}
	}
}



	