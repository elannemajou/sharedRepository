package com.katas.question28;

public class Question28StaticTest {

	public static Object Lock1 = new Object();
	public static Object Lock2 = new Object();

	public static void main(String args[]) {

		Runnable runnable1 = new Runnable(){
			public void run() {
				synchronized (Lock1) {
					System.out.println("Thread 1: Holding lock 1...");
					try { Thread.sleep(10); }
					catch (InterruptedException e) {}
					System.out.println("Thread 1: Waiting for lock 2...");
					synchronized (Lock2) {
						System.out.println("Thread 1: Holding lock 1 & 2...");
					}
				}
			}
		};

		Runnable runnable2 = new Runnable(){
			public void run() {
				synchronized (Lock2) {
					System.out.println("Thread 2: Holding lock 2...");
					try { Thread.sleep(10); }
					catch (InterruptedException e) {}
					System.out.println("Thread 2: Waiting for lock 1...");
					synchronized (Lock1) {
						System.out.println("Thread 2: Holding lock 1 & 2...");
					}
				}
			}
		};



		Thread T1 = new Thread(runnable1);
		Thread T2 = new Thread(runnable2);
		T1.start();
		T2.start();
	}

}



